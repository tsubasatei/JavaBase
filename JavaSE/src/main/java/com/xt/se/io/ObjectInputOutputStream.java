package com.xt.se.io;

import java.io.*;

/**
 * @author xt
 * @Desc
 */
public class ObjectInputOutputStream {
    public static void main(String[] args) {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        ObjectInputStream ois = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ObjectOutputStream oos = null;

        try {

            fos = new FileOutputStream(new File("123.txt"));
            bos = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(bos);
            oos.write(100);
            oos.writeUTF("世界如此美好");
            oos.writeObject(new Person(1, "zhangsan", "123"));
            oos.flush();

            fis = new FileInputStream(new File("123.txt"));
            bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);
            System.out.println(ois.read());
            System.out.println(ois.readUTF());
            System.out.println(ois.readObject());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
