package org.wadec.sauce.util.stor;

import org.wadec.sauce.net.Link;

/**
 *
 * @author Wade C
 */
public class ConnectionManager {

    private Link[] links = new Link[0];

    public Link[] getLinks() {
        return links;
    }

    public void addLink(Link l) {
        Link[] t = new Link[links.length + 1];
        for (int i = 0; i < links.length; i++) {
            t[i] = links[i];
        }
        t[links.length] = l;
        links = t;
    }

    public void delLink(Link l) {
        Link[] t = new Link[links.length - 1];
        boolean f = false;
        for (int i = 0; i < links.length; i++) {
            if (links[i] == l) {
                f = true;
                continue;
            }
            t[f ? i - 1 : i] = links[i];
        }
        links = t;
    }
}
