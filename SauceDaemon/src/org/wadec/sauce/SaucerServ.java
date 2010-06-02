package org.wadec.sauce;

import java.io.IOException;
import org.wadec.sauce.util.Logger;

/**
 *
 * @author Wade C
 */
public class SaucerServ {

    public final Logger LOGGER = new Logger("./log");
    private final ServerHost SERVER;

    public SaucerServ() throws IOException {
        SERVER = new ServerHost();
    }
}
