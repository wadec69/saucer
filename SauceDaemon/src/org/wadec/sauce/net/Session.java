package org.wadec.sauce.net;

/**
 *
 * @author Wade C
 */
public interface Session {

    public int sessionId();

    public boolean isDead();

    public void exec();
}
