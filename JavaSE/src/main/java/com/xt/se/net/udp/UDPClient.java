package com.xt.se.net.udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @author xt
 * @Desc
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(10000);
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        DatagramPacket packet = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("localhost"), 10001);
        socket.send(packet);
        socket.close();
    }
}
