package com.xt.se.basic.io;

import java.io.*;

/**
 * @author xt
 * @Desc
 */
public class Test06_System {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);

        File file = new File("D:\\test.txt");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        String str;
        while (!(str = br.readLine()).equals("exist")) {
            bw.write(str);
            bw.newLine();
        }

        bw.close();
        br.close();

    }
}
