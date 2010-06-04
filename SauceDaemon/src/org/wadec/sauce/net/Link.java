package org.wadec.sauce.net;

import java.io.IOException;
import java.net.Socket;
import org.wadec.sauce.SauceServ;
import org.wadec.sauce.io.Stream;
import org.wadec.sauce.net.ses.Normal;

/**
 *
 * @author Wade C
 */
public class Link {

    private Socket socket;
    private Stream stream;
    private SauceServ sauce;
    private Session session;

    public Link(Socket s, SauceServ serv) throws IOException {
        socket = s;
        stream = new Stream(socket);
        sauce = serv;
        sendInit();
    }

    public boolean isOnline() {
        return socket.isClosed() ? false : true;
    }

    public String read() throws IOException {
        String in = stream.read();
        if (in == null) {
            close("Timeout");
        }
        return in;
    }

    public void print(String out) {
        stream.print(out);
    }

    public SauceServ getServer() {
        return sauce;
    }

    public Session startSession() throws IOException {
        Session s = null;
        if (session == null) {
            String sesType = read();
            if (sesType != null) {
                if (sesType.startsWith("SES:")) {
                    sesType = sesType.substring(sesType.indexOf(":") + 1);
                    if (sesType.equals("1")) {
                        s = new Normal(this);
                    }
                }
                if (s == null) {
                    close("Improper Headers");
                }
            }
        }
        return s;

    }

    public void close(String r) throws IOException {
        stream.print("CONNECTION CLOSURE NOTICE : [ " + r + " ]");
        sauce.LOGGER.print("(" + socket.getInetAddress().getHostName() + ") Link closed - " + r);
        sauce.getManager().delLink(this);
        socket.close();
    }

    private void sendInit() {
        stream.print("Connected to: " + sauce.getConfig().getVersion());
    }
}
