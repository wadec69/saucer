package org.wadec.sauce.net.ses;

import org.wadec.sauce.net.Link;
import org.wadec.sauce.net.Session;

/**
 *
 * @author Wade C
 */
public class Normal implements Session {

    private Link link;

    public Normal(Link l) {
        link = l;
    }

    public int sessionId() {
        return 1;
    }

    public boolean isDead() {
        return link.isOnline() ? false : true;
    }

    public void exec() {
        try {
            String in = link.read();
            if (in != null)
                link.getServer().LOGGER.print("(Input) " + in);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
