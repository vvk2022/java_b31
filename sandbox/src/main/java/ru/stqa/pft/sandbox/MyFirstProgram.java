package ru.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {
        Point startPoint = new Point(10, 10);
        Point endPoint = new Point(20, 20);

        System.out.println("Distance between start point and end point is: " + startPoint.distance(endPoint));
    }

}