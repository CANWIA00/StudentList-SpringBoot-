package com.StudentList.StudentList.controller;

import com.StudentList.StudentList.Dto.Request.CreateStudentRequest;
import com.StudentList.StudentList.Dto.Request.UpdateStudentRequest;
import com.StudentList.StudentList.Dto.StudentDto;
import com.StudentList.StudentList.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/studentlist")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable String id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        return  ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody CreateStudentRequest createStudentRequest){
        return ResponseEntity.ok(studentService.createStudent(createStudentRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable String id,@RequestBody UpdateStudentRequest updateStudentRequest){
        return  ResponseEntity.ok(studentService.updateStudent(id, updateStudentRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }





}
