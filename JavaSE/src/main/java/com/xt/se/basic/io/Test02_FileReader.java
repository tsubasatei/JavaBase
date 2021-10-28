package com.xt.se.basic.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author xt
 * @Desc
 */
public class Test02_FileReader {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\test.txt");
        FileReader fr = new FileReader(file);

//        int read;
//        while ((read = fr.read()) != -1) {
//            System.out.println((char)read);
//        }

        char[] ch = new char[5];
        int len;
        while ((len = fr.read(ch)) != -1) {
            System.out.println(new String(ch, 0, len));
        }

        fr.close();


    }
}
