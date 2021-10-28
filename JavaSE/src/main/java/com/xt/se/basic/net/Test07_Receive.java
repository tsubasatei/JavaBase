package com.xt.se.basic.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author xt
 * @Desc
 */
public class Test07_Receive {
    public static void main(String[] args) throws IOException {
        System.out.println("BB上线了");
        DatagramSocket ds = null;
        Scanner sc = null;
        try {
            ds = new DatagramSocket(9999);
            while (true) {
                byte[] bytes = new byte[1024];
                DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
                ds.receive(dp);
                byte[] data = dp.getData();
                String str = new String(data, 0, dp.getLength());
                System.out.println("AA对我说：" + str);
                if (str.equals("bye")) {
                    System.out.println("AA下线了");
                    break;
                }
                System.out.print("BB: ");
                sc = new Scanner(System.in);
                String str2 = sc.next();
                byte[] b = str2.getBytes();
                DatagramPacket dp2 = new DatagramPacket(b, b.length, InetAddress.getByName("localhost"), 8888);
                ds.send(dp2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ds.close();
        }
    }
}
