package com.StudentList.StudentList.Dto;

import com.StudentList.StudentList.model.Sex;
import com.StudentList.StudentList.model.Teacher;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class StudentDto implements Serializable {

    private String id;
    private String name;
    private String surname;
    private Sex sex;
    private Integer birthDate;
    private Teacher teachername;
}
