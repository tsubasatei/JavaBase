package com.xt.pizza;

import java.util.Scanner;

/**
 * @author xt
 * @Desc
 */
public class OrderPizza {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请选择想要制作的披萨：1. 培根披萨， 2.水果披萨：");
        int type = scanner.nextInt();
        Pizza pizza = PizzaFactory.createPizza(type);
        System.out.println(pizza.showInfo());
    }
}
