package com.xt.se.basic.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author xt
 * @Desc
 */
public class Test04_FileCopy {
    public static void main(String[] args) {
        File f1 = new File("D:\\test.txt");
        File f2 = new File("D:\\demo.txt");

        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(f1);
            fw = new FileWriter(f2);

            char[] ch = new char[5];
            int len;
            while ((len = fr.read(ch)) != -1) {
                String str = new String(ch, 0, len);
                fw.write(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fw) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
