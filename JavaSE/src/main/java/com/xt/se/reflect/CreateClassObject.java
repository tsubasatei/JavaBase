package com.xt.se.reflect;

/**
 * @author xt
 * @Desc
 */
public class CreateClassObject {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<Person> clazz = (Class<Person>) Class.forName("com.xt.se.reflect.Person");
        System.out.println(clazz.getPackage());
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getCanonicalName());

        Class<Person> clazz2 = Person.class;
        System.out.println(clazz2.getSimpleName());

        Class<? extends Person> clazz3 = new Person().getClass();
        System.out.println(clazz3.getCanonicalName());

        // 如果是一个基本数据类型，那么可以通过Type的方式来获取Class对象
        Class<Integer> type = Integer.TYPE;
        System.out.println(type.getName()); // int
        Class<Integer> integerClass = Integer.class;
        System.out.println(integerClass.getName()); // java.lang.Integer
        Class<Integer> integerClass1 = int.class;
        System.out.println(integerClass1); // int
    }
}
