package com.xt.se.io;

import java.io.File;
import java.io.IOException;

/**
 * @author xt
 * @Desc
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("abc.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        System.out.println(file.canWrite());
        System.out.println(file.canRead());
        System.out.println(file.canExecute());

        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        // 获取文件的父路径名称，如果文件的路径中只包含文件名称，则显示空
        System.out.println(file.getParent());

        System.out.println(file.getCanonicalPath());
        System.out.println(File.separator);
        System.out.println(file.getUsableSpace());

        File file1 = new File("d:/");
        System.out.println(file1.getAbsolutePath());

        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());

        File[] files = file1.listFiles();
        for (File f : files) {
            System.out.println(f);
        }

        System.out.println("---------");

        String[] list = file1.list();
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("=============");

        File[] files1 = File.listRoots();
        for (int i = 0; i < files1.length; i++) {
            System.out.println(files1[i]);
        }

//        file = new File("d:/a/b");
//        file.mkdir();
//        file.mkdirs();

        // 递归打印文件
        file = new File("D:\\project\\javase");
        printFile(file);

    }

    private static void printFile(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                printFile(file1);
            }
        } else {
            System.out.println(file.getAbsolutePath());
        }
    }
}
