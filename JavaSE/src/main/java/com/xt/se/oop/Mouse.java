package com.xt.se.oop;

/**
 * @author xt
 * @Desc
 */
public class Mouse implements USB{
    @Override
    public void dataTransfer() {
        System.out.println("鼠标点击屏幕");
    }
}
