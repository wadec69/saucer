package org.wadec.sauce.net;

/**
 *
 * @author Wade C
 */
public class LinkSession implements Runnable {

    private Session session;

    public LinkSession(Session s) {
        session = s;
    }

    public void run() {
        try {
            while (!session.isDead()) {
                session.exec();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
