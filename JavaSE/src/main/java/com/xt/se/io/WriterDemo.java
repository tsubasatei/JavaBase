package com.xt.se.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author xt
 * @Desc
 */
public class WriterDemo {
    public static void main(String[] args)  {
        FileWriter fw = null;
        try {
            fw = new FileWriter(new File("123.txt"));
            fw.write("亮亮的星星相随\n");
            fw.write("虫儿飞，虫儿飞，你在思念谁");
            fw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
