package com.xt.se.net.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xt
 * @Desc
 */
public class LoginServer2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("服务器已启动。。。");
        ServerSocket serverSocket = new ServerSocket(10088);
        while (true) {
            Socket socket = serverSocket.accept();
            LoginThread loginThread = new LoginThread(socket);
            new Thread(loginThread).start();
        }
    }
}
