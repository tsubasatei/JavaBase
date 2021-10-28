package com.xt.se.io;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;

/**
 * @author xt
 * @Desc
 */
public class CharArrayReaderWriter {
    public static void main(String[] args) {
        char[] chars = "中国跳水梦之队".toCharArray();
        CharArrayReader reader = new CharArrayReader(chars);
        CharArrayWriter crw = new CharArrayWriter();
        try {
            int read = 0;
            while ((read = reader.read()) != -1) {
                System.out.println((char)read);
            }
            
            crw.write(100);
            crw.write(chars);
            crw.write("你好");
            System.out.println(crw.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reader.close();
            crw.close();
        }
    }
}
