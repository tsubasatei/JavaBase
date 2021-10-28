package com.xt.se.basic.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xt
 * @Desc
 */
public class Test03_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String str = dis.readUTF();
        System.out.println("收到来自客户端的信息：" + str);

        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("你好，我是服务器，我收到了你的请求！！！");

        dos.close();
        dis.close();
        s.close();
        ss.close();
    }
}
