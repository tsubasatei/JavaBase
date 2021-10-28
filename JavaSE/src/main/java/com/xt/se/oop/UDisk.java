package com.xt.se.oop;

/**
 * @author xt
 * @Desc
 */
public class UDisk implements USB{
    @Override
    public void dataTransfer() {
        System.out.println("U盘传输数据");
    }
}
