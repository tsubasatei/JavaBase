package com.xt.se.basic.net;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author xt
 * @Desc
 */
public class Test04_Client {
    public static void main(String[] args) {

        Scanner sc = null;
        Socket s = null;
        ObjectOutputStream oos = null;
        DataInputStream dis = null;
        try {
            s = new Socket("192.168.0.14", 8888);

            sc = new Scanner(System.in);
            System.out.print("请输入用户名：");
            String name = sc.next();
            System.out.print("请输入密码：");
            String pwd = sc.next();
            User user = new User(name, pwd);

            OutputStream os = s.getOutputStream();
            oos = new ObjectOutputStream(os);
            oos.writeObject(user);

            InputStream is = s.getInputStream();
            dis = new DataInputStream(is);
            boolean flag = dis.readBoolean();
            if (flag) {
                System.out.println("恭喜，登录成功！");
            } else {
                System.out.println("用户名或密码错误。");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dis != null) {
                    dis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (s != null) {
                    s.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
