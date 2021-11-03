package com.StudentList.StudentList.Dto.Request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateStudentRequest extends BaseStudentRequest{
    @NotBlank(message = "Student id must not be empty")
    private String id;
}
