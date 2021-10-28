package com.xt.se.basic.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author xt
 * @Desc
 */
public class Test03_FileWriter {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\test.txt");
        FileWriter fw = new FileWriter(file, true);
        String str = "中国梦之队";
        /*for (int i = 0; i < str.length(); i++) {
            fw.write(str.charAt(i));
        }*/
        fw.write(str.toCharArray());
        fw.close();
    }
}
