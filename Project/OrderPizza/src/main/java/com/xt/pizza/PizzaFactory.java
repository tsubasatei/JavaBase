package com.xt.pizza;

import java.util.Scanner;

/**
 * @author xt
 * @Desc
 */
public class PizzaFactory {

    public static Pizza createPizza(int type) throws Exception {
        Pizza pizza = null;
        Scanner scanner = new Scanner(System.in);
        switch (type) {
            case 1:
                System.out.println("请输入培根的克数：");
                int weight = scanner.nextInt();
                System.out.println("请输入披萨的大小");
                int size = scanner.nextInt();
                System.out.println("请输入披萨的价格：");
                int price = scanner.nextInt();
                pizza = new BaconPizza("水果披萨", price, size, weight);
                break;
            case 2:
                System.out.println("请输入想要加入的水果：");
                String fruits = scanner.next();
                System.out.println("请输入披萨的大小");
                size = scanner.nextInt();
                System.out.println("请输入披萨的价格：");
                price = scanner.nextInt();
                pizza = new FruitPizza("水果披萨", price, size, fruits);
                break;
        }
        return pizza;
    }
}
