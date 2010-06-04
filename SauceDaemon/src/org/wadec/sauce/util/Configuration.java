package org.wadec.sauce.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Wade C
 */
public class Configuration {

    private String[] key = new String[0];
    private String[] value = new String[0];

    public Configuration() {
        load();
    }

    public String getVersion() {
        return "SaucerDaemon v 0.1a";
    }

    public String getValue(String k) {
        for (int i = 0; i < key.length; i++) {
            if (key[i].equals(k)) {
                return value[i];
            }
        }
        return null;
    }

    private void load() {
        try {
            File f = new File("./cfg");
            if (!f.exists()) {
                return;
            }
            BufferedReader r = new BufferedReader(new FileReader(f));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
