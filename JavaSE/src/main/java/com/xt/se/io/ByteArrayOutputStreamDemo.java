package com.xt.se.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author xt
 * @Desc
 */
public class ByteArrayOutputStreamDemo {
    public static void main(String[] args) {
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream();
            bos.write(100);
            bos.write("中国梦".getBytes());
            System.out.println(bos.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
