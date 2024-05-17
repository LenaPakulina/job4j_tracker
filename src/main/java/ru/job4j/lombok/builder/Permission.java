package ru.job4j.lombok.builder;

import lombok.*;

import java.util.List;

@Builder(builderMethodName = "of")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@ToString
public class Permission {
    @EqualsAndHashCode.Include
    private int id;

    private String name;

    @Singular("addRule")
    private List<String> rules;
}
