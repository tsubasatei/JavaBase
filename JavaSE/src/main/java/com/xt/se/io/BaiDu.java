package com.xt.se.io;

import java.io.*;
import java.net.URL;

/**
 * @author xt
 * @Desc
 */
public class BaiDu {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(), "UTF-8"));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html")));) {
            String str = "";
            while ((str = br.readLine()) != null) {
                bw.write(str);
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
