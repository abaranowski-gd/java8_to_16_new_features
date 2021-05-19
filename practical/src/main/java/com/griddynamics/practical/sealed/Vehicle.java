package com.griddynamics.practical.sealed;

public sealed abstract class Vehicle implements Movable permits Car, Truck{
    protected String name;

    protected String getName(){
        return this.name;
    }
}
