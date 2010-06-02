package org.wadec.sauce.net;

import java.net.Socket;

/**
 *
 * @author Wade C
 */
public class Link {

    private Socket socket;

    public Link(Socket s) {
        socket = s;
    }
}
