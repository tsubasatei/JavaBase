package com.xt.se.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExerciseDemo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入课程编号");
        try{
            int i  = scanner.nextInt();
            if(i == 0){
                System.out.println("java");
            }else if(i == 1){
                System.out.println("scala");
            }else{
                System.out.println("python");
            }
        }catch (InputMismatchException e){
            e.printStackTrace();
        }finally {
            System.out.println("欢迎选课");
        }
    }
}
