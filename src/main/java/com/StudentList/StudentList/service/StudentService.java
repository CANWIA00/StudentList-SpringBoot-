package com.StudentList.StudentList.service;

import com.StudentList.StudentList.Dto.StudentDto;
import com.StudentList.StudentList.Dto.Request.CreateStudentRequest;
import com.StudentList.StudentList.Dto.Request.UpdateStudentRequest;
import com.StudentList.StudentList.Dto.converter.StudentDtoConverter;
import com.StudentList.StudentList.model.Student;
import com.StudentList.StudentList.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentDto getStudentById(String id){
        return studentRepository.findById(id)
                .map(StudentDtoConverter::convert)
                .orElse(new StudentDto());
    }

    public List<StudentDto> getAllStudents(){
        List<Student>studentList = studentRepository.findAll();

        List<StudentDto>studentDtoList = new ArrayList<>();

        for (Student student : studentList){
            studentDtoList.add(StudentDtoConverter.convert(student));
        }
        return studentDtoList;
    }

    public StudentDto createStudent( CreateStudentRequest createStudentRequest){
        Student student = new Student();
        student.setId(createStudentRequest.getId());
        student.setName(createStudentRequest.getName());
        student.setSurname(createStudentRequest.getSurname());
        student.setSex(createStudentRequest.getSex());
        student.setBirthDate(createStudentRequest.getBirthDate());
        student.setTeachername(createStudentRequest.getTeachername());

        studentRepository.save(student);

        return StudentDtoConverter.convert(student);
    }

    public StudentDto updateStudent(String id, UpdateStudentRequest updateStudentRequest){
        Optional<Student> studentOptional = studentRepository.findById(id);

        studentOptional.ifPresent(student -> {
            student.setName(updateStudentRequest.getName());
            student.setSurname(updateStudentRequest.getSurname());
            student.setSex(updateStudentRequest.getSex());
            student.setBirthDate(updateStudentRequest.getBirthDate());
            student.setTeachername(updateStudentRequest.getTeachername());

            studentRepository.save(student);
        });

        return studentOptional.map(StudentDtoConverter::convert).orElse(new StudentDto());
    }

    public void deleteStudent(String id){
    studentRepository.deleteById(id);
    }



}
