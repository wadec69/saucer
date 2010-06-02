package org.wadec.sauce;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author Wade C
 */
public class ServerHost {

    private ServerSocket server;

    public ServerHost() throws IOException {
        server = new ServerSocket(16254);
    }
}
