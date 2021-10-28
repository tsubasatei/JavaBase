package com.xt.se.basic.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * @author xt
 * @Desc
 */
public class Test03_LocalDate {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalDate localDate1 = LocalDate.of(1983, 10, 28);
        System.out.println(localDate1);

        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonth()); // SEPTEMBER
        System.out.println(localDate.getMonthValue()); // 9
        System.out.println(localDate.getDayOfMonth()); // 17
        System.out.println(localDate1.getDayOfWeek()); // FRIDAY

        LocalDate localDate2 = localDate.withMonth(8);
        System.out.println(localDate);
        System.out.println(localDate2);

        LocalDate localDate3 = localDate.plusMonths(4);
        System.out.println(localDate);
        System.out.println(localDate3);

        LocalDate localDate4 = localDate.minusDays(5);
        System.out.println(localDate);
        System.out.println(localDate4);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.now();
        String s = dtf.format(ldt);
        System.out.println(s);
        TemporalAccessor parse = dtf.parse(s);
        System.out.println(parse);

    }
}
