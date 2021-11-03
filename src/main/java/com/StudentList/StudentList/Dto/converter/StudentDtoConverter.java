package com.StudentList.StudentList.Dto.converter;

import com.StudentList.StudentList.Dto.StudentDto;
import com.StudentList.StudentList.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentDtoConverter {

    public static StudentDto convert(Student student){
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .surname(student.getSurname())
                .sex(student.getSex())
                .birthDate(student.getBirthDate())
                .build();
    }
}
