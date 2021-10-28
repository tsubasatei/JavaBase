package com.xt.se.basic.io;

import java.io.*;

/**
 * @author xt
 * @Desc
 */
public class Test05_FileCopy4 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("D:\\test.txt");
        File f2 = new File("D:\\demo.txt");

        FileReader fis = new FileReader(f1);
        FileWriter fos = new FileWriter(f2);

        BufferedReader br = new BufferedReader(fis);
        BufferedWriter bw = new BufferedWriter(fos);

        String str;
        while ((str = br.readLine()) != null) {
            bw.write(str);
            bw.newLine();
        }

        // 关闭高阶流
        bw.close();
        br.close();
    }
}
