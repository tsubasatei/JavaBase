package com.xt.se.base;

import java.util.Scanner;

/**
 * @author xt
 * @Desc
 */
public class For {
    public static void main(String[] args) {
        /*for (int i = 1; i <= 100; i++) {
            System.out.println("第" + i + "遍输出");
        }*/

        /*int sum = 0;
        for (int i = 1; i <= 100 ; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println("100以内偶数和：" + sum);*/

        /*Scanner sc = new Scanner(System.in);
        int above30 = 0;
        int below30 = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.println("请输入第" + i + "位顾客的年龄：");
            if(sc.nextInt() > 30){
                above30++;
            } else {
                below30++;
            }
        }
        System.out.println("30岁以上的顾客占：" + ((double)(above30) / 10 * 100) + "%");
        System.out.println("30岁以下的顾客占：" + ((double)(below30) / 10 * 100) + "%");*/

        // 将10进制整数变成二进制
        /*Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个十进制数：");
        int i = sc.nextInt();
        int mod;
        String s = "";
        while (i != 0) {
            mod = i % 2;
            s = mod + s;
            i /= 2;
        }
        System.out.println("其对应的二进制为：" + s);*/

        // 九九乘法表
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " * " + j + " = " + (i * j) + "\t");
            }
            System.out.println();
        }

        // 斐波那契额数列
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要打印的斐波那契额数列的个数：");
        int count = scanner.nextInt();
        /*int num1 = 0;
        int num2 = 0;
        int num = 0;
        for (int i = 1; i <= count; i++) {
            if (i == 1 || i == 2) {
                num1 = 1;
                num2 = 1;
                System.out.print(num1 + "\t");
            } else {
                num = num1 + num2;
                num1 = num2;
                num2 = num;
                System.out.print(num + "\t");
            }
        }*/

        // 递归实现, 层次深，栈溢出
        for (int i = 1; i <= count; i++) {
            int num = fab(i);
            System.out.print(num + "\t");
        }

        System.out.println();
        // 百鸡买百钱问题
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 33; j++) {
                for (int k = 0; k <= 100; k++) {
                    if ((i + j + k) == 100 && (5 * i + 3 * j + k / 3) == 100 && (k % 3 == 0)) {
                        System.out.println("公鸡：" + i + ", 母鸡：" + j + ", 小鸡：" + k);
                    }
                }
            }
        }
    }

    private static int fab(int count) {
        if (count == 1 || count == 2) {
            return 1;
        } else {
            return fab(count - 1) + fab(count - 2);
        }
    }
}
