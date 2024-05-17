package ru.job4j.lombok.builder;

import java.util.List;

class LombokUsage {
    public static void main(String[] args) {
        var role = Role.of()
                .id(1)
                .name("ADMIN")
                .accessBy("first")
                .accessBy("second")
                .accessBy(List.of("3", "4"))
                .build();
        System.out.println(role);
    }
}
