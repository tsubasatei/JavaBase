package com.xt.se.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author xt
 * @Desc
 */
public class ClassAPI {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName("com.xt.se.reflect.Student");
        // 获取成员变量,包括子类及父类，同时只能包含公共的方法
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
            System.out.println(field.getName());
            System.out.println(field.getType());
            System.out.println(field.getModifiers());
            System.out.println("--------------");
        }
        System.out.println("==============");
        // 此方法返回的是当前类的所有属性，不仅仅局限于公共访问修饰符，所有的访问修饰符都可以拿到
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
            System.out.println(field.getName());
            System.out.println(field.getType());
            System.out.println(field.getModifiers());
            System.out.println("--------------");
        }

        Field address = clazz.getDeclaredField("address");
        address.setAccessible(true);
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
        Student o = (Student) declaredConstructor.newInstance();
        address.set(o, "北京");
        System.out.println(o.getAddress());

        System.out.println("==============");

        // 获取该对象的普通方法,包含的方法范围是当前对象及父类对象的所有公共方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        System.out.println("---------------");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }
        System.out.println("-----------");

        Method add = clazz.getDeclaredMethod("add", int.class, int.class);
        add.setAccessible(true);
        Object invoke = add.invoke(o, 10, 20);
        System.out.println(invoke);

        System.out.println("==================");
        // 获取对象的所有构造方法，只能获取公有的构造方法
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }
        System.out.println("---------------");
        // 获取所有的构造方法，无论是私有还是公有
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println(constructor.getName());
        }

        System.out.println("-------------");
        Constructor<?> declaredConstructor1 = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        declaredConstructor1.setAccessible(true);
        Student o1 = (Student) declaredConstructor1.newInstance("zhangsan", 18, "Java");
        System.out.println(o1);
    }
}
