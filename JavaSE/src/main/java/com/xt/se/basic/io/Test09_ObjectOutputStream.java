package com.xt.se.basic.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author xt
 * @Desc
 */
public class Test09_ObjectOutputStream {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("D:\\text.txt")));
        oos.writeObject(new Person("张三", "123", 18));
        oos.close();
    }
}
