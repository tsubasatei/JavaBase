package com.xt.se.net.tcp;

import java.io.*;
import java.net.Socket;

/**
 * @author xt
 * @Desc
 */
public class LoginThread implements Runnable{
    private Socket socket;

    public LoginThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream ois = null;
        DataOutputStream dos = null;
        try {
            InputStream is = socket.getInputStream();
            ois = new ObjectInputStream(is);
            User user = (User) ois.readObject();
            Boolean flag;
            if (user.getUsername().equals("admin") && user.getPassword().equals("123")) {
                flag = true;
            } else {
                flag = false;
            }
            socket.shutdownInput();

            OutputStream os = socket.getOutputStream();
            dos = new DataOutputStream(os);
            dos.writeBoolean(flag);
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
