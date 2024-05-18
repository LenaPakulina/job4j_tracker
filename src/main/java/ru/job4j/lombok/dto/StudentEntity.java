package ru.job4j.lombok.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentEntity {
    private int id;
    private String name;
    private String classVal;
}
