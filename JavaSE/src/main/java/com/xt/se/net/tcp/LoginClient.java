package com.xt.se.net.tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author xt
 * @Desc
 */
public class LoginClient {
    public static void main(String[] args) throws IOException {
        System.out.println("--------------登录系统-------------");
        while (true) {
            Socket socket = new Socket("localhost", 10088);
            User user = login();
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(user);
            socket.shutdownOutput();

            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            boolean b = dis.readBoolean();
            if (b) {
                System.out.println("登录成功");
                break;
            } else {
                System.out.println("用户名密码错误，请重新输入");
            }
            socket.shutdownInput();

            dis.close();
            oos.close();
            socket.close();
        }
    }

    public static User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String username = scanner.next();
        System.out.print("请输入密码：");
        String password = scanner.next();
        User user = new User(username, password);
        return user;
    }
}
