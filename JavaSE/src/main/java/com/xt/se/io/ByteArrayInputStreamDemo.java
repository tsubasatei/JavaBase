package com.xt.se.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.BitSet;

/**
 * @author xt
 * @Desc
 */
public class ByteArrayInputStreamDemo {
    public static void main(String[] args) {
        ByteArrayInputStream bis = null;
        try {
            String str = "abcdefg";
            byte[] bytes = str.getBytes();
            bis = new ByteArrayInputStream(bytes);
            int read;
            while ((read = bis.read()) != -1) {
                bis.skip(4);
                System.out.println((char)read);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
