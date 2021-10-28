package com.xt.se.oop;

/**
 * @author xt
 * @Desc
 */
public class CodeBlock {
    int a;
    int b;

    static {
        System.out.println("静态代码块");
    }
    {
        System.out.println("构造代码块");
    }

    public CodeBlock() {
        System.out.println("构造方法");
    }

    public CodeBlock(int a) {
        this.a = a;
    }

    public CodeBlock(int a, int b) {
        this(a);
        this.b = b;
    }

    public void test() {
        {
            System.out.println("普通代码块");
        }
    }

    public static void main(String[] args) {
        CodeBlock codeBlock = new CodeBlock();
        codeBlock.test();
        {
            System.out.println("main");
        }
    }
}
