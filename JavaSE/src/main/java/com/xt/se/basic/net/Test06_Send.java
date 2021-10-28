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
public class Test06_Send {
    public static void main(String[] args) throws IOException {
        System.out.println("AA上线了");
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(8888);
            while (true) {
                System.out.print("AA: ");
                Scanner sc = new Scanner(System.in);
                String str = sc.next();
                byte[] bytes = str.getBytes();
                DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("localhost"), 9999);
                ds.send(dp);
                if (str.equals("bye")) {
                    break;
                }
                byte[] b = new byte[1024];
                DatagramPacket dp2 = new DatagramPacket(b, b.length);
                ds.receive(dp2);
                byte[] data2 = dp2.getData();
                String str2 = new String(data2, 0, dp2.getLength());
                System.out.println("BB对我说：" + str2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ds.close();
        }
    }
}
