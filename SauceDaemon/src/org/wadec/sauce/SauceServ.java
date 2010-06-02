package org.wadec.sauce;

import java.io.IOException;
import org.wadec.sauce.util.Logger;

/**
 *
 * @author Wade C
 */
public class SauceServ {

    public final Logger LOGGER = new Logger("./log");
    private final ServerHost SERVER;

    public SauceServ() throws IOException {
        SERVER = new ServerHost();
    }
}
