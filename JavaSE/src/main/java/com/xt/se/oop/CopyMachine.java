package com.xt.se.oop;

/**
 * @author xt
 * @Desc
 */
public class CopyMachine implements InkBox, Paper{
    @Override
    public void getWhiteAndBlock() {
        System.out.println("黑白打印");
    }

    @Override
    public void getColor() {
        System.out.println("彩色打印");
    }

    @Override
    public void getA4() {
        System.out.println("A4纸打印");
    }

    @Override
    public void getB5() {
        System.out.println("B5纸打印");
    }

    public static void main(String[] args) {
        CopyMachine copyMachine = new CopyMachine();
        copyMachine.getColor();
        copyMachine.getA4();
    }
}
