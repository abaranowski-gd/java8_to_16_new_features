package com.griddynamics.practical.sealed;

public class SealedClassesExample {
    public static void main(String[] args) {

        Movable car = new Car();
        Movable smallCar = new SmallCar();
        Movable fiatUno = new FiatUno();
        Movable truck = new Truck();

        car.move();
        smallCar.move();
        fiatUno.move();
        truck.move();

    }
}
