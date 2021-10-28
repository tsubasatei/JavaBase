package com.xt.charge;

import java.util.Scanner;

/**
 * @author xt
 * @Desc
 */
public class Client {
    static Scanner sc = new Scanner(System.in);
    static String details = "";
    static int balance = 0;
    public static void main(String[] args) {
        while (true) {
            menu();
            System.out.print("请输入你要选择的功能：");
            int choice = sc.nextInt();
            while (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
                System.out.print("对不起，没有你要选择的功能，请重新选择: ");
                choice = sc.nextInt();
            }
            switch (choice) {
                case 1:
                    detail();
                    break;
                case 2:
                    income();
                    break;
                case 3:
                    outcome();
                    break;
                case 4:
                    quit();
                    break;
                default:
                    System.out.println("对不起，没有你要选择的功能，请重新选择!");
            }
        }
    }

    private static void quit() {
        System.out.println("记账系统 》》》》退出功能");
        System.out.print("您确定要退出吗？y/n ");
        String confirm = sc.next();
        if (confirm.equals("y") || confirm.equals("Y")) {
            System.out.println("Bye！");
            System.exit(0);
        }
    }

    private static void outcome() {
        System.out.println("记账系统 》》》》登记支出");
        System.out.print("请录入支出金额：");
        int outcome = sc.nextInt();
        System.out.print("请录入支出说明：");
        String desc = sc.next();
        balance -= outcome;
        details += "支出：" + outcome + ", 支出说明：" + desc + "，账户余额：" + balance + "\n";
    }

    private static void income() {
        System.out.println("记账系统 》》》》登记收入");
        System.out.print("请录入收入金额：");
        int income = sc.nextInt();
        System.out.print("请录入收入说明：");
        String desc = sc.next();
        balance += income;
        details += "收入：" + income + ", 收入说明：" + desc + "，账户余额：" + balance + "\n";
    }

    private static void detail() {
        System.out.println("记账系统 》》》》收支明细");
        if (details.equals("")) {
            System.out.println("暂无记录");
        } else {
            System.out.println(details.substring(0, details.length() - 1));
        }
    }

    public static void menu() {
        System.out.println("---------------欢迎使用记账系统-------------------");
        System.out.println("1. 收支明细");
        System.out.println("2. 登记收入");
        System.out.println("3. 登记支出");
        System.out.println("4. 退    出");
        System.out.println("-----------------------------");
    }
}
