package com.xt.se.io;

import java.io.*;

/**
 * @author xt
 * @Desc
 */
public class DatatInputOutputStream {
    public static void main(String[] args) {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        DataOutputStream dos = null;

        try {

            fos = new FileOutputStream(new File("123.txt"));
            bos = new BufferedOutputStream(fos);
            dos = new DataOutputStream(bos);
            dos.write(100);
            dos.writeUTF("世界如此美好");
            dos.writeBoolean(true);
            dos.writeDouble(3.14);
            dos.writeChar('c');
            dos.flush();

            fis = new FileInputStream(new File("123.txt"));
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);
            System.out.println(dis.read());
            System.out.println(dis.readUTF());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readDouble());
            System.out.println(dis.readChar());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
