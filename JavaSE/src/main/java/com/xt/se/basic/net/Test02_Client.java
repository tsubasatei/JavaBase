package com.xt.se.basic.net;

import java.io.*;
import java.net.Socket;

/**
 * @author xt
 * @Desc
 */
public class Test02_Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("192.168.0.14", 8888);
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("你好");

        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String str = dis.readUTF();
        System.out.println("来自服务器的消息：" + str);
        dis.close();
        dos.close();
        s.close();

    }
}
