package com.xt.se.oop;

/**
 * @author xt
 * @Desc
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point point) {
        return Math.sqrt(Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2));
    }

    public void change(Point point) {
        int x = this.x;
        this.x = point.x;
        point.x = x;

        int y = this.y;
        this.y = point.y;
        point.y = y;

    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        Point point = new Point(1, 2);
        Point point1 = new Point(5, 5);
        System.out.println(point.distance(point1));
        System.out.println(point);
        System.out.println(point1);

        point.change(point1);
        System.out.println(point);
        System.out.println(point1);
    }
}
