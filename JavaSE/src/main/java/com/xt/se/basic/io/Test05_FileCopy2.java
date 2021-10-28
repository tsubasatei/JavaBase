package com.xt.se.basic.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author xt
 * @Desc
 */
public class Test05_FileCopy2 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("D:\\madara.jpg");
        File f2 = new File("D:\\pic.jpg");

        FileInputStream fis = new FileInputStream(f1);
        FileOutputStream fos = new FileOutputStream(f2);

        byte[] b = new byte[1024 * 6];
        int len;
        while ((len = fis.read(b)) != -1) {
            fos.write(b, 0, len);
        }

        fos.close();
        fis.close();
    }
}
