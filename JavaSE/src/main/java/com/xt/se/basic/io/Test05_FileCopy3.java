package com.xt.se.basic.io;

import java.io.*;

/**
 * @author xt
 * @Desc
 */
public class Test05_FileCopy3 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("D:\\madara.jpg");
        File f2 = new File("D:\\pic.jpg");

        FileInputStream fis = new FileInputStream(f1);
        FileOutputStream fos = new FileOutputStream(f2);

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        byte[] b = new byte[1024 * 6];
        int len;
        while ((len = bis.read(b)) != -1) {
            bos.write(b, 0, len);
        }

        // 关闭高阶流
        bos.close();
        bis.close();
    }
}
