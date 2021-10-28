package com.xt.se.io;

import java.io.*;

/**
 * @author xt
 * @Desc
 */
public class BufferInputOutputStream {
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(new File("123.txt")));
            bos = new BufferedOutputStream(new FileOutputStream(new File("124.txt")));
            int read;
            while ((read = bis.read()) != -1) {
                bos.write(read);
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
