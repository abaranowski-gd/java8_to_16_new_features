package com.griddynamics.practical.sealed;

public sealed interface Movable permits Vehicle{
    void move();

    default boolean canMove(){
        System.out.println("I can move!");
        return true;
    }
}
