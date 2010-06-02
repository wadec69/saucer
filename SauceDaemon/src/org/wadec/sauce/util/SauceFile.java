package org.wadec.sauce.util;

/**
 *
 * @author Wade C
 */
public class SauceFile {

    private String name;
    private String[] file;

    public SauceFile(String n, String[] f) {
        name = n;
        file = f;
    }

    public String getName() {
        return name;
    }

    public String[] getFile() {
        return file;
    }
}
