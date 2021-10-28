package com.xt.se.basic.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xt
 * @Desc
 */
public class Test01_Sdf {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String s = sdf.format(date);
        System.out.println(s);

        Date d = sdf.parse("2020-09-17 14:36:12");
        System.out.println(d);
        System.out.println(d.toString());
        System.out.println(d.toGMTString());
        System.out.println(d.toLocaleString());
        System.out.println(System.currentTimeMillis());
    }
}
