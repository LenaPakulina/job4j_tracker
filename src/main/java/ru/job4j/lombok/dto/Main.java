package ru.job4j.lombok.dto;

import org.mapstruct.factory.Mappers;

public class Main {
    public static void main(String[] args) {
        StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);
        StudentEntity sEntity = new StudentEntity(0, "entity", "junior");
        StudentDto sDto = new StudentDto(11, "dto", "middle");
        StudentDto fromEntity = studentMapper.getModelFromEntity(sEntity);
        System.out.println("fromEntity = " + fromEntity);
        StudentEntity fromDto = studentMapper.getEntityFromDto(sDto);
        System.out.println("fromDto = " + fromDto);
    }
}
