package com.xt.se.base;

import java.util.Scanner;

/**
 * @author xt
 * @Desc
 */
public class AddCust {
    public static void main(String[] args) {
        System.out.println("--------欢迎光临会员系统------");
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入会员号码：");
        String number = sc.next();
        System.out.print("请输入会员生日<日/月>：");
        String birthday = sc.next();
        System.out.print("请输入会员积分：");
        int score = sc.nextInt();
        if (number.length() == 4) {
            System.out.println("会员信息如下：");
            System.out.println(number + "\t" + birthday + "\t" + score);
        } else {
            System.out.println("会员号码输入错误，请输入4位证数");
        }
    }
}
