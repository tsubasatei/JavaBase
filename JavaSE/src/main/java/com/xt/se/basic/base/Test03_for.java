package com.xt.se.basic.base;

/**
 * @author xt
 * @Desc
 */
public class Test03_for {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " * " + j + " = " + (i * j) + "\t");
            }
            System.out.println();
        }

        System.out.println("----------------");

        for (int i = 9; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " * " + j + " = " + (i * j) + "\t");
            }
            System.out.println();
        }

        System.out.println("----矩形------");

        for (int j = 1; j <= 4; j++) {
            for (int i = 0; i < 9; i++) {
                System.out.print(" ");
            }
            for (int i = 1; i < 9; i++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("-----平行四边形-----");

        for (int j = 1; j <= 4; j++) {
            for (int i = 1; i <= 10 - j ; i++) {
                System.out.print(" ");
            }
            for (int i = 1; i < 9; i++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("-----上三角形-----");

        for (int j = 1; j <= 4; j++) {
            for (int i = 1; i <= 10 - j ; i++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= 2*j-1; i++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("-----菱形-----");

        for (int j = 1; j <= 4; j++) {
            for (int i = 1; i <= 10 - j ; i++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= 2*j-1; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int j = 3; j >= 1; j--) {
            for (int i = 1; i <= 10 - j ; i++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= 2*j-1; i++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("-----空心菱形-----");

        for (int j = 1; j <= 4; j++) {
            for (int i = 1; i <= 10 - j ; i++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= 2*j-1; i++) {
                if (i == 1 || i == 2 * j - 1) System.out.print("*");
                else System.out.print(" ");

            }
            System.out.println();
        }
        for (int j = 1; j <= 3; j++) {
            for (int i = 1; i <= j + 6 ; i++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= 7 - 2 * j; i++) {
                if (i == 1 || i == 7 - 2 * j) System.out.print("*");
                else System.out.print(" ");

            }
            System.out.println();
        }

        System.out.println("==========打印菱形的第二种方式============");

        int size = 7; // 规模
        int startNum = size / 2 + 1; // 起始列号
        int endNum = size / 2 + 1; // 结束列号
        boolean flag = true; // 开关
        for (int i = 1; i <= size ; i++) {
            for (int j = 1; j <= size ; j++) {
                if (j >= startNum && j <= endNum) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            if (endNum == size) flag = false;
            if (flag) {
                startNum --;
                endNum ++;
            } else {
                startNum++;
                endNum--;
            }
        }

        System.out.println("==========打印空心菱形的第二种方式============");

        int size2 = 7; // 规模
        int startNum2 = size2 / 2 + 1; // 起始列号
        int endNum2 = size2 / 2 + 1; // 结束列号
        boolean flag2 = true; // 开关
        for (int i = 1; i <= size2 ; i++) {
            for (int j = 1; j <= size2 ; j++) {
                if (j == startNum2 || j == endNum2) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            if (endNum2 == size2) flag2 = false;
            if (flag2) {
                startNum2 --;
                endNum2 ++;
            } else {
                startNum2++;
                endNum2--;
            }
        }
    }
}
