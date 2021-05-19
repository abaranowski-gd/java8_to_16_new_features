package com.griddynamics.practical.sealed;

public sealed class Car extends Vehicle permits SmallCar{
    private static final int STEP = 10;

    public Car() {
        this.name = "Car";
    }

    @Override
    public void move() {
        if(canMove()){
            System.out.println("I'am " + getName() + " and I moved " + STEP + " kilometers.");
        }
    }
}
