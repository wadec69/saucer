package org.wadec.sauce.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 *
 * @author Wade C
 */
public class Logger {

    private PrintWriter writer;

    public Logger(String dir) throws IOException {
        writer = new PrintWriter(new FileWriter(dir));
    }

    public void print(String out) {
        writer.println("[" + date() + "] " + out);
        writer.flush();
        System.out.println("[" + date() + "] " + out);
    }

    private String date() {
        Date d = new Date();
        int h = d.getHours(), m = d.getMinutes(), s = d.getSeconds();
        return (h < 10 ? "0" + h : h) + ":" +
                (m < 10 ? "0" + m : m) + ":" +
                (s < 10 ? "0" + s : s);
    }
}
