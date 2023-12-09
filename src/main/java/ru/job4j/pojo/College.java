package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student petya = new Student();
        petya.setFullName("Petr Arsentev");
        petya.setGroup("NNN-111");
        petya.setStudentFromDate(new Date());

        System.out.println("Student: " + petya.getFullName()
                + ", group: " + petya.getGroup()
                + ", from: " + petya.getStudentFromDate());
    }
}
