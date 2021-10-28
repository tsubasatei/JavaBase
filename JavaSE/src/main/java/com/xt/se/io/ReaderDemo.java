package com.xt.se.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author xt
 * @Desc
 */
public class ReaderDemo {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader(new File("123.txt"));
            int read;
//            while ((read = reader.read()) != -1) {
//                System.out.println((char)read);
//            }
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {
                System.out.println(new String(chars, 0, read));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
