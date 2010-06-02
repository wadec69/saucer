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

    public ServerHost() throws IOException {
        server = new ServerSocket(16254);
    }

    public Link getNext() throws IOException {
        return new Link(server.accept());
    }
}
