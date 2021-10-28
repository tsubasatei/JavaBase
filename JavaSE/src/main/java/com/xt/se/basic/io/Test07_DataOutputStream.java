package com.xt.se.basic.io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author xt
 * @Desc
 */
public class Test07_DataOutputStream {
    public static void main(String[] args) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("D:\\text.txt")));
        dos.writeUTF("你好");
        dos.writeBoolean(false);
        dos.writeDouble(8.9);
        dos.writeInt(10);

        dos.close();
    }
}
