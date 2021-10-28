package com.xt.se.basic.io;

import java.io.Serializable;

/**
 * @author xt
 * @Desc
 */
public class Person implements Serializable {
    private static final long serialVersionUID = -6277179111592565026L;
    private String name;
    private transient String pwd;
    private Integer age;
    private static String nation = "China";

    public Person() {
    }

    public Person(String name, String pwd, Integer age) {
        this.name = name;
        this.pwd = pwd;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                '}';
    }
}
