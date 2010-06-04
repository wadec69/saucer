package org.wadec.sauce;

import java.io.IOException;
import java.net.ServerSocket;
import org.wadec.sauce.net.Link;

/**
 *
 * @author Wade C
 */
public class ServerHost {

    private ServerSocket server;
    private SauceServ sauce;

    public ServerHost(SauceServ s) throws IOException {
        server = new ServerSocket(16254);
        sauce = s;
    }

    public Link getNext() throws IOException {
        return new Link(server.accept(), sauce);
    }
}
