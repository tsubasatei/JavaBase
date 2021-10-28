package com.xt.se.base;

/**
 * @author xt
 * @Desc
 */
public class BreakContinueReturn {
    public static void main(String[] args) {
        /*int count = 0;
        while (true) {
            int i = (int)(Math.random() * 101);
            if (i == 88) {
                break;
            }
            count++;
            System.out.println(count + "--" + i);
        }*/

        /*out:for (int i = 1; i <= 10 ; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.println("(" + i + ", " + j + ")") ;
                if (i == 6 && j == 6) {
                    break out;
                }
            }
        }*/

        /*for (int i = 100; i < 150; i++) {
            if (i % 3 == 0) {
                continue;
            }
            System.out.println(i);
        }*/

        System.out.println(get());
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i == 5) {
//                return;
                System.exit(0);
            }
            System.out.println("接着执行");
        }

    }

    private static int get() {
        return 100;
    }
}
