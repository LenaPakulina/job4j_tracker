package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Едем.");
    }

    @Override
    public void passangers(int count) {
        System.out.println("Кол-во пассажиров: " + count);
    }

    @Override
    public double refuel(double petrol) {
        return petrol * 100;
    }
}
