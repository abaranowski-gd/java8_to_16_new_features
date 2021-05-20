package com.griddynamics.practical.sealed;

public sealed interface Movable permits Vehicle{
    String MESSAGE = "I can move!";
    void move();

    // Default method (Since Java 8)
    default boolean canMove(){
        print();
        return true;
    }

    // Notice private method here (Since Java 9)
    private void print(){
        System.out.println(MESSAGE);
    }
}
