package com.xt.se.basic.io;

import java.io.*;

/**
 * @author xt
 * @Desc
 */
public class Test05_FileCopy5 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("D:\\test.txt");
        File f2 = new File("D:\\demo.txt");

        FileInputStream fis = new FileInputStream(f1);
        FileOutputStream fos = new FileOutputStream(f2);

        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");

        char[] ch = new char[5];
        int len;
        while ((len = isr.read(ch)) != -1) {
            osw.write(ch, 0, len);
        }

        // 关闭高阶流
        isr.close();
        osw.close();
    }
}
