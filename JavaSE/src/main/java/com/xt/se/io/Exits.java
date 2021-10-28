package com.xt.se.io;

import java.io.*;

/**
 * @author xt
 * @Desc
 */
public class Exits {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
            String str = "";
            while (!(str = br.readLine()).equals("exit")) {
                bw.write(str);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
