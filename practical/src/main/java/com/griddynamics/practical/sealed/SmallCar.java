package com.griddynamics.practical.sealed;

// Any other class can extends this one because it's not sealed or final
public non-sealed class SmallCar extends Car {
    public SmallCar() {
        super();
        this.name = getName() + "(but very small)";
    }

}
