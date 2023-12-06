package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void show() {
        System.out.println("Name: " + this.name + ". Food: " + this.food);
    }

    public String sound() {
        return "may-may";
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.giveNick("Tom");
        gav.show();
        Cat black = new Cat();
        black.eat("fish");
        black.giveNick("Darkness");
        black.show();
    }
}
