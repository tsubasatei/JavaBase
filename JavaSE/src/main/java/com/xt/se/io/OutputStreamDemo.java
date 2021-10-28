package com.xt.se.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author xt
 * @Desc
 */
public class OutputStreamDemo {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("abc.txt"));
            fos.write(100);
            fos.write("天生我材必有用".getBytes());
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
