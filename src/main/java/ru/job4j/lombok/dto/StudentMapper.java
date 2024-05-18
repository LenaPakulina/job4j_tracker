package ru.job4j.lombok.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface StudentMapper {
    @Mapping(target = "className", source = "classVal")
    StudentDto getModelFromEntity(StudentEntity student);

    @Mapping(target = "classVal", source = "className")
    StudentEntity getEntityFromDto(StudentDto studentDto);
}
