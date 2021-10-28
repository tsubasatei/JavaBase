package com.xt.se.exception;

import java.util.Scanner;

/**
 * @author xt
 * @Desc
 */
public class ExceptionDemo {
    public static void main(String[] args) {

        try {
            test();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("hehe");
        /*Scanner sc = new Scanner(System.in);
        try {
            System.out.println("请输入被除数：");
            int num1 = sc.nextInt();
            System.out.println("请输入除数：");
            int num2 = sc.nextInt();
            int num = num1 / num2;
            System.out.println(String.format("%d / %d = %d", num1, num2, num));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("出现异常");
        } finally {
            System.out.println("感谢使用本程序");
        }*/
    }

    public static void test() throws Exception{
        System.out.println(1 / 0);
        throw new Exception("除数不能为0");
    }

}
