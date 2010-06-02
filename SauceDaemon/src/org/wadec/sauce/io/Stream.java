package org.wadec.sauce.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Wade C
 */
public class Stream {

    private PrintStream writer;
    private BufferedReader reader;

    public Stream(Socket s) throws IOException {
        writer = new PrintStream(s.getOutputStream());
        reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    public String read() throws IOException {
        return reader.readLine();
    }

    public void print(String out) {
        writer.println(out);
        writer.flush();
    }
}
