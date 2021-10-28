package com.xt.se.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author xt
 * @Desc
 */
public class InputStreamDemo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File("abc.txt"));
//            int read;
//            while ((read = fis.read()) != -1) {
//                System.out.println((char) read);
//            }

//            byte[] bytes = new byte[1024];
//            int length;
//            while ((length = fis.read(bytes)) != -1) {
//                System.out.println(new String(bytes, 0, length));
//            }

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes, 5, 5)) != -1) {
                System.out.println(new String(bytes, 5, length));
            }

            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
