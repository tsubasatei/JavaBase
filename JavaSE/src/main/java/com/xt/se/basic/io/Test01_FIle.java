package com.xt.se.basic.io;

import java.io.File;
import java.io.IOException;

/**
 * @author xt
 * @Desc
 */
public class Test01_FIle {

    public static void main(String[] args) throws IOException {
        File f1 = new File("D:\\test.txt");
        File f2 = new File("D:/test.txt");
        File f3 = new File("D:"+ File.separator + "test.txt");

        System.out.println("是否可读：" + f1.canRead());
        System.out.println("是否可写：" + f1.canWrite());
        System.out.println("文件名：" + f1.getName());
        System.out.println("父目录：" + f1.getParent());
        System.out.println("是否是目录：" + f1.isDirectory());
        System.out.println("是否是文件：" + f1.isFile());
        System.out.println("是否隐藏：" + f1.isHidden());
        System.out.println("是否存在：" + f1.exists());

        /*if (f1.exists()) {
            f1.delete();
        } else {
            f1.createNewFile();
        }*/

        File f4 = new File("d:\\test.txt");
        System.out.println(f1 == f4);
        System.out.println(f1.equals(f4));

        System.out.println(f1.getAbsolutePath());
        System.out.println(f1.getPath());
        System.out.println(f1.toString());

        System.out.println("---------------");

        File f5 = new File("demo.txt");
        System.out.println(f5.getAbsolutePath());
        System.out.println(f5.getPath());
        System.out.println(f5.toString());

        // 目录相关操作
        File f6 = new File("D:\\a\\b");
        System.out.println(f6.mkdir());
        System.out.println(f6.mkdirs());
        System.out.println(f6.delete());

        File f = new File("D:\\myproject");
        String[] list = f.list();
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("============");
        File[] files = f.listFiles();
        for (File file : files) {
            System.out.println(file.getName() + ", " + file.getAbsolutePath());
        }
    }
}
