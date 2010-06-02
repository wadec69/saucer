package org.wadec.sauce.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Wade C
 */
public class Logger {

    private PrintWriter writer;

    public Logger(String dir) throws IOException {
        writer = new PrintWriter(new FileWriter(dir));
    }
}
