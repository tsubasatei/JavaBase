package com.xt.se.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author xt
 * @Desc
 */
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        InetAddress inetAddress = InetAddress.getByName("DESKTOP-31F8KC3");
        System.out.println(inetAddress);
        System.out.println(inetAddress.getHostAddress());
        System.out.println(inetAddress.getHostName());
    }
}
