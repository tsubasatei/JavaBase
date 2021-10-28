package com.xt.se.io;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @author xt
 * @Desc
 */
public class PrintStreamDemo {
    public static void main(String[] args) {
        PrintStream ps = new PrintStream(System.out);
        try {
            ps.write("Hello world".getBytes());
            ps.println(true);
            System.out.println();
            System.out.printf("%s--%d--%.2f", "abc", 100, 3.1415);
            System.err.println("1234");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ps.close();
        }

    }
}
