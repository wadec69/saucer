package org.wadec.sauce;

import java.io.IOException;

/**
 *
 * @author Wade C
 */
public class SaucerServ {

    private final ServerHost SERVER;

    public SaucerServ() throws IOException {
        SERVER = new ServerHost();
    }
}
