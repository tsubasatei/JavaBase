package com.xt.se.oop;

import java.util.Scanner;

/**
 * @author xt
 * @Desc
 */
public class Administrator {
    String loginName = "admin";
    String password = "123";

    public void introduce() {
        System.out.println(loginName);
        System.out.println(password);
    }

    public static void main(String[] args) {
        Administrator admin = new Administrator();
        System.out.println(admin.loginName);
        System.out.println(admin.password);
        admin.introduce();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入用户名：");
            String name = sc.next();
            System.out.println("请输入密码：");
            String pwd = sc.next();

            if (name.equals(admin.loginName) && pwd.equals(admin.password)) {
                System.out.println("请输入新密码：");
                String newPwd = sc.next();
                admin.password = newPwd;
                System.out.println("密码修改成功");
                break;
            } else {
                System.out.println("用户名密码不正确，请重新输入");
            }
        }
        admin.introduce();
    }
}
