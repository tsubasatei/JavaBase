package com.xt.se.collection;

/**
 * @author xt
 * @Desc
 */
public class Generic<T> {
    private Integer id;
    private T t;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Generic{" +
                "id=" + id +
                ", t=" + t +
                '}';
    }

    public static void main(String[] args) {
        Generic<String> generic = new Generic<>();
        generic.setT("abc");
        System.out.println(generic);
    }
}
