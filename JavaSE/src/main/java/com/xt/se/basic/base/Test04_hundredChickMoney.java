package com.xt.se.basic.base;

/**
 * @author xt
 * @Desc: 公鸡5文一只，母鸡3文一只，小鸡3只一文
 * 用100文钱买100只鸡，其中公鸡母鸡，小鸡都必须要有，问公鸡，母鸡，小鸡要买多少只刚好凑足100文
 */
public class Test04_hundredChickMoney {
    public static void main(String[] args) {
        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 31; j++) {
                int z = 100 - i - j;
                if (5 * i + 3 * j + z / 3 == 100 && z % 3 == 0) {
                    System.out.println("公鸡：" + i + ", 母鸡: " + j + ", 小鸡：" + z);
                }
            }
        }
    }
}
