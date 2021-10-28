package com.xt.se.basic.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author xt
 * @Desc
 */
public class Test10_ObjectInputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:\\text.txt")));
        com.xt.se.basic.io.Person p = (com.xt.se.basic.io.Person) ois.readObject();
        System.out.println(p);
        ois.close();
    }
}
