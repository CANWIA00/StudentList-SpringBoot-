package com.StudentList.StudentList.Dto.Request;

import com.StudentList.StudentList.model.Sex;
import com.StudentList.StudentList.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseStudentRequest {

    @NotBlank(message="Student id can not be null")
    private String id;
    @NotNull(message = "Student name can not be null")
    private String name;
    @NotNull(message = "Student surname can not be null")
    private String surname;
    @NotNull(message = "Student sex can not be null")
    private Sex sex;
    @NotNull(message = "Student birthDate can not be null")
    private Integer birthDate;
    @NotNull(message = "Teacher name can not be null")
    private Teacher teachername;
}
