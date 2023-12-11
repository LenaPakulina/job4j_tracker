package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static String answer(int code) {
        return switch (code) {
            case 0 -> "Да";
            case 1 -> "Нет";
            default -> "Может быть";
        };
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String question = input.nextLine();
        System.out.println(answer(new Random().nextInt(3)));
    }
}
