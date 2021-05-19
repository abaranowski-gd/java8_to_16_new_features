package com.griddynamics.practical.sealed;

public final class Truck extends Vehicle {
    private static final int STEP = 5;

    public Truck() {
        this.name = "Truck";
    }

    @Override
    public void move() {
        if(canMove()){
            System.out.println("I'am " + getName() + " and I moved " + STEP + " kilometers.");
        }
    }
}
