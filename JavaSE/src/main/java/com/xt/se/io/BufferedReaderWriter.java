package com.xt.se.io;

import java.io.*;

/**
 * @author xt
 * @Desc
 */
public class BufferedReaderWriter {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        
        try {
            br = new BufferedReader(new FileReader(new File("123.txt")));
            bw = new BufferedWriter(new FileWriter("124.txt"));
            String str = "";
            while ((str = br.readLine()) != null) {
                bw.write(str);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
