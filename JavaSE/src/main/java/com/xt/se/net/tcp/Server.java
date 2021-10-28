package com.xt.se.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xt
 * @Desc
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);
        System.out.println("服务器已启动。。。");
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int read = is.read(bytes);
        System.out.println("客户端：" + new String(bytes, 0, read));

        OutputStream os = socket.getOutputStream();
        os.write("您好，客户端".getBytes());

        os.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
