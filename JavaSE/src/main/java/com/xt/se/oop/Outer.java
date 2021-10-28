package com.xt.se.oop;

/**
 * @author xt
 * @Desc 内部类中不能定义静态属性
 */
public class Outer {
    private Integer id;
    private String name = "zhangsan";

    public void show() {
        System.out.println("show");
        System.out.println(id);
        new Inner().test();
        class InnerClass {
            private Integer age;
            public void show() {
                System.out.println("inner show");
            }
        }
        new InnerClass().show();
    }

    class Inner {
        private Integer age;
        private String name = "lisi";
        public void test() {
            System.out.println(this.name);
            System.out.println(Outer.this.name);
        }
    }

    static class InnerClass {
        private String name;
        public void show() {
            System.out.println("static inner show");
        }
    }

    public static void main(String[] args) {
        Inner inner = new Outer().new Inner();
        inner.test();

        System.out.println("-------------");
        InnerClass innerClass = new InnerClass();
        innerClass.show();

        System.out.println("-------------");
        new Outer().show();
    }
}
