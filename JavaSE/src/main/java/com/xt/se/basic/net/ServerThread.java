package com.xt.se.basic.net;

import java.io.*;
import java.net.Socket;

/**
 * @author xt
 * @Desc
 */
public class ServerThread extends Thread {
    private Socket s;

    public ServerThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        ObjectInputStream ois = null;
        DataOutputStream dos = null;
        try {
            InputStream is = s.getInputStream();
            ois = new ObjectInputStream(is);
            User user = (User) ois.readObject();
            boolean flag = false;
            if (user.getName().equals("admin") && user.getPwd().equals("123")) {
                flag = true;
            }
            System.out.println("收到来自客户端的信息：" + user);

            OutputStream os = s.getOutputStream();
            dos = new DataOutputStream(os);
            dos.writeBoolean(flag);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (ois != null) {
                    ois.close();
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
