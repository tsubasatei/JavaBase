package com.xt.se.basic.util;

import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

/**
 * @author xt
 * @Desc 打印日历
 */
public class Test02_Calendar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你想要查看的日期：（提示：请按照例如2020-5-6的格式书写）: ");
        String strDate = sc.next();
        Date date = Date.valueOf(strDate);
//        System.out.println("当前时间：" + date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
//        System.out.println(cal);

        System.out.println("日\t一\t二\t三\t四\t五\t六");
        int maxDay = cal.getActualMaximum(Calendar.DATE);
//        System.out.println(maxDay);
        int curDay = cal.get(Calendar.DATE);
        cal.set(Calendar.DATE, 1);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
//        System.out.println(dayOfWeek);
        int spaceDay = dayOfWeek - 1;
        for (int i = 0; i < spaceDay; i++) {
            System.out.print(" \t");
        }
        int count = spaceDay;
        for (int i = 1; i <= maxDay; i++) {
            if (i == curDay) {
                System.out.print(i + "*\t");
            } else {
                System.out.print(i + "\t");
            }
            count++;
            if (count % 7 == 0) {
                System.out.println();
            }
        }
    }
}
