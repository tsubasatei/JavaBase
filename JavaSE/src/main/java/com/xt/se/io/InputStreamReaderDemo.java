package com.xt.se.io;

import java.io.*;

/**
 * @author xt
 * @Desc
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;

        try {
            fis = new FileInputStream(new File("abc.txt"));
            isr = new InputStreamReader(fis);

            char[] chars = new char[1024];
            int length;
            fos = new FileOutputStream(new File("123.txt"));
            osw = new OutputStreamWriter(fos);

            while ((length = isr.read(chars)) != -1) {
                osw.write(new String(chars, 0, length));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
