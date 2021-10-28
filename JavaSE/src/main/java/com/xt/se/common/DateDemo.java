package com.xt.se.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xt
 * @Desc
 */
public class DateDemo {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m:s");
        String s = sdf.format(date);
        System.out.println(s);

        Date date1 = sdf.parse("2021-9-26 18:15:51");
        System.out.println(date1);

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        calendar.setTime(date1);
        System.out.println(calendar);
        System.out.println(calendar.getWeekYear());
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.HOUR));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));

    }
}
