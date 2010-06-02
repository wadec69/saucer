package org.wadec.sauce.net;

import java.io.IOException;
import java.net.Socket;
import org.wadec.sauce.io.Stream;

/**
 *
 * @author Wade C
 */
public class Link {

    private Socket socket;
    private Stream stream;

    public Link(Socket s) throws IOException {
        socket = s;
        stream = new Stream(socket);
    }
}
