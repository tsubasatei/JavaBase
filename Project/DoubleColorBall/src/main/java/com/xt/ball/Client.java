package com.xt.ball;

import java.util.Scanner;

/**
 * @author xt
 * @Desc
 */
public class Client {
    static Scanner sc = new Scanner(System.in);
    static int[] arr = new int[7];
    static int count;
    static int[] res = new int[7];
    static boolean flag = false;
    public static void main(String[] args) {
        generateResult();

        while (true) {
            menu();
            System.out.print("请选择菜单：");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    buy();
                    break;
                case 2:
                    if (flag) {
                        check();
                    } else {
                        System.out.println("请先购买彩票！！！");
                    }
                    break;
                case 3:
                    quit();
                    break;
            }
        }
    }

    private static void generateResult() {
        for (int i = 0; i < 6; i++) {
            res[i] = ((int)Math.random() * 33) + 1;
        }
        res[6] =  ((int)Math.random() * 16) + 1;
//        res = new int[]{1, 2, 3, 4, 5, 6, 7};
    }

    private static void quit() {
        System.out.println("----双色球彩票系统 》》》》》退出系统------------");
        System.out.print("您确定要退出吗？y/n ");
        String confirm = sc.next();
        if (confirm.equals("y") || confirm.equals("Y")) {
            System.out.println("Bye！");
            System.exit(0);
        }
    }

    private static void check() {
        System.out.println("----双色球彩票系统 》》》》》查看开奖------------");
        System.out.println("中将号码为：");
        print(res);
        int level = getLevel(arr, res);
        switch(level){
            case 1:
                System.out.println("恭喜，您中一等奖500万元，一共获得" + (500 * count) + "万元");
                break;
            case 2:
                System.out.println("恭喜，您中二等奖100万元，一共获得" + (100 * count) + "万元");
                break;
            case 3:
                System.out.println("恭喜，您中三等奖50万元，一共获得" + (5 * count) + "万元");
                break;
            case 4:
                System.out.println("恭喜，您中四等奖2000元，一共获得" + (2000 * count) + "元");
                break;
            case 5:
                System.out.println("恭喜，您中五等奖100元，一共获得" + (100 * count) + "元");
                break;
            case 6:
                System.out.println("恭喜，您中一等奖5元，一共获得" + (5 * count) + "元");
                break;
            default:
                System.out.println("很遗憾，您没有中奖！");
        }
    }

    private static int getLevel(int[] arr, int[] res) {
        int red = 0;
        int blue = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] == arr[i]) {
                if (i == res.length - 1) {
                    blue ++;
                } else {
                    red ++;
                }
            }
        }
        int level;
        if (red == 6 && blue == 1) {
            level = 1;
        } else if (red == 6){
            level = 2;
        } else if (red == 5 && blue == 1 ) {
            level = 3;
        } else if (red == 5 || (red == 4 && blue == 1)) {
            level = 4;
        } else if (red == 4 || (red == 3 && blue == 1)) {
            level = 5;
        } else {
            level = 6;
        }
        System.out.println("红球相等个数为：" + red);
        System.out.println("蓝球相等个数为：" + blue);
        return level;
    }

    private static void buy() {
        System.out.println("----双色球彩票系统 》》》》》购买彩票------------");
        System.out.print("请输入您需要下多少注：");
        count = sc.nextInt();
        for (int i = 0; i < 6; i++) {
            System.out.println("请选择6个红球，第" + (i + 1) + "个红球为：红球在（1-33之间）");
            arr[i] = sc.nextInt();
        }
        System.out.println("请选择1个蓝球，蓝球为：蓝球在（1-16之间）");
        arr[6] = sc.nextInt();
        System.out.println("您一共买了【" + count + "】注，一共花费" + (2 * count) + "元钱，所选的号码为：");
        print(arr);
        flag = true;
    }

    private static void menu() {
        System.out.println("-----------欢迎进入双色球彩票系统---------------");
        System.out.println("\t\t\t\t1. 购买彩票");
        System.out.println("\t\t\t\t2. 查看开奖");
        System.out.println("\t\t\t\t3. 退    出");


    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
