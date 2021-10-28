package com.xt.se.collection;

/**
 * @author xt
 * @Desc
 */
public class GenericMethod<T> {
    private T id;
    private <E> void method(E e) {
        System.out.println(e);
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public static void main(String[] args) {
        GenericMethod<String> genericMethod = new GenericMethod<>();
        genericMethod.method(123);
    }
}
