package com.xt.se.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author xt
 * @Desc
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 10086);
        OutputStream os = socket.getOutputStream();
        os.write("你好, 服务器".getBytes());

        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int read = is.read(bytes);
        System.out.println(new String(bytes, 0, read));

        is.close();
        os.close();
        socket.close();

    }
}
