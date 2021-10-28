package com.xt.se.basic.oop;

class Shape {
    private String name = "shape";
    private float area;
    public Shape() {
        System.out.println("shape");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }
}

public class T {
    public static void main(String[] args) {
        Shape s = new Shape();
        s.setArea(1.0f);
        System.out.println(s.getArea());
        System.out.println(s.getName());
        char a = '汗';
    }
}
