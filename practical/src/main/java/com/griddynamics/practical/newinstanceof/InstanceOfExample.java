package com.griddynamics.practical.newinstanceof;

public class InstanceOfExample {
    public static void main(String[] args) {
        Shape obj = new Square();

        // Old
        if (obj instanceof Circle){
            System.out.println(((Circle)obj).getRadius());
        }else if(obj instanceof Square)
            System.out.println(((Square)obj).getNumOfCorners());

        // New
        if (obj instanceof Circle circle){
            System.out.println(circle.getColor());
        }else if(obj instanceof Square square)
            System.out.println(square.getNumOfCorners());
    }
}
