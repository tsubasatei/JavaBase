package com.xt.se.net.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xt
 * @Desc
 */
public class LoginServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("服务器已启动。。。");
        ServerSocket serverSocket = new ServerSocket(10088);
        while (true) {
            Socket socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            User user = (User) ois.readObject();
            Boolean flag;
            if (user.getUsername().equals("admin") && user.getPassword().equals("123")) {
                flag = true;
            } else {
                flag = false;
            }
            socket.shutdownInput();

            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeBoolean(flag);
            socket.shutdownOutput();

            dos.close();
            ois.close();
            socket.close();
        }
    }
}
