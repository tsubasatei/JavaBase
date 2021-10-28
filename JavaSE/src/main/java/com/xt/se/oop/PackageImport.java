package com.xt.se.oop;

import java.util.Date;

import static java.lang.Math.sqrt;

/**
 * @author xt
 * @Desc
 */
public class PackageImport {
    public static void main(String[] args) {
        Date date = new Date();
        java.sql.Date date1 = new java.sql.Date(date.getTime());

        sqrt(2);
    }
}
