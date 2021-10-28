package com.xt.se.base;

import java.util.Scanner;

/**
 * @author xt
 * @Desc
 */
public class If {
    public static void main(String[] args) {
        int i = (int)(Math.random() * 6 );
        if (i > 3) {
            System.out.println("值大于3");
        }
        System.out.println("number = " + i);

        /*Scanner sc = new Scanner(System.in);
        System.out.print("请输入圆的半径: ");
        int r = sc.nextInt();
        double c = 2 * Math.PI * r;
        double s = Math.PI * Math.pow(r, 2);
        if (c > s) {
            System.out.println("周长大于面积");
        } else {
            System.out.println("面积大于等于周长");
        }*/

        int age = (int)(Math.random() * 100);
        if (age < 10) {
            System.out.println("儿童");
        } else if (age < 20) {
            System.out.println("少年");
        } else if (age < 30) {
            System.out.println("青年");
        } else if (age < 50) {
            System.out.println("中年");
        } else if (age < 70) {
            System.out.println("老年");
        } else {
            System.out.println("耄耋");
        }

        int time = (int)(Math.random() * 40);
        if (time < 20) {
            System.out.println("恭喜进入决赛");
            String gender = (int)(Math.random() * 2) == 0 ? "girl" : "boy";
            if (gender == "girl") {
                System.out.println("欢迎进入女子组");
            } else {
                System.out.println("欢迎进入男子组");
            }
        } else {
            System.out.println("成绩太差，加油吧，少年!");
        }

        int random = (int)(Math.random() * 26);
        char ch = (char) ('a' + random);
        switch(ch){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println("元音：" + ch);
                break;
            case 'y':
            case 'w':
                System.out.println("半元音：" + ch);
                break;
            default:
                System.out.println("辅音：" + ch);
        }
    }
}
