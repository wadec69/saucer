package org.wadec.sauce;

import java.io.IOException;
import org.wadec.sauce.net.Link;
import org.wadec.sauce.net.LinkSession;
import org.wadec.sauce.net.Session;
import org.wadec.sauce.util.Configuration;
import org.wadec.sauce.util.stor.ConnectionManager;
import org.wadec.sauce.util.Logger;

/**
 *
 * @author Wade C
 */
public class SauceServ {

    public final Logger LOGGER;
    private ServerHost server;
    private ConnectionManager connections = new ConnectionManager();
    private Configuration config = new Configuration();
    private boolean online = false;

    public SauceServ() throws IOException {
        LOGGER = new Logger("./log");
        server = new ServerHost(this);
        LOGGER.print("(SauceServ) Server instance created.");
    }

    public void initialize() throws IOException {
        if (!online) {
            run();
        } else {
            LOGGER.print("(ERROR) ServerHost is already online!");
        }
    }

    public ConnectionManager getManager() {
        return connections;
    }

    public Configuration getConfig() {
        return config;
    }

    public ServerHost getServer() {
        return server;
    }

    private void run() throws IOException {
        online = true;
        LOGGER.print("(SauceServ) Now listening.");
        while (true) {
            Link l = server.getNext();
            //TODO: add code that will disable the client if their host is from a banned one (via ConnectionManager)
            connections.addLink(l);
            LOGGER.print("(SauceServ) New link established");
            Session s = l.startSession();
            if (s != null) {
                new Thread(new LinkSession(s)).start();
            }
        }
    }
}
