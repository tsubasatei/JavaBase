package com.xt.se.basic.net;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * @author xt
 * @Desc
 */
public class Test01_InetAddress {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ia = InetAddress.getByName("192.168.0.14");
        System.out.println(ia);
        ia = InetAddress.getByName("localhost");
        System.out.println(ia);
        ia = InetAddress.getByName("127.0.0.1");
        System.out.println(ia);
        ia = InetAddress.getByName("DESKTOP-31F8KC3");
        System.out.println(ia);
        ia = InetAddress.getByName("www.baidu.com");
        System.out.println(ia);

        System.out.println(ia.getHostName());
        System.out.println(ia.getHostAddress());
        System.out.println(ia.getAddress());
        System.out.println(ia.getCanonicalHostName());

        InetSocketAddress isa = new InetSocketAddress("192.168.0.14", 8080);
        System.out.println(isa);

        System.out.println(isa.getHostName());
        System.out.println(isa.getAddress());
        System.out.println(isa.getPort());
    }
}
