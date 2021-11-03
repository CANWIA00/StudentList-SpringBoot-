package com.StudentList.StudentList;

import com.StudentList.StudentList.model.Sex;
import com.StudentList.StudentList.model.Student;
import com.StudentList.StudentList.model.Teacher;
import com.StudentList.StudentList.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class StudentListApplication implements CommandLineRunner {

	private final StudentRepository studentRepository;

	public StudentListApplication(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(StudentListApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student student = Student.builder()
				.id("3131")
				.name("Pelis")
				.surname("Ergul")
				.sex(Sex.FEMALE)
				.teachername(Teacher.Benil)
				.birthDate(2002)
				.build();

		Student student1 = Student.builder()
				.id("982")
				.name("Omer")
				.surname("Arslan")
				.sex(Sex.MALE)
				.birthDate(1999)
				.teachername(Teacher.Benil)
				.build();

		Student student2 = Student.builder()
				.id("289")
				.name("Benil")
				.surname("Ergul")
				.sex(Sex.FEMALE)
				.birthDate(2000)
				.teachername(Teacher.Omer)
				.build();

		Student student3 = Student.builder()
				.id("621")
				.name("Talha")
				.surname("Kartal")
				.sex(Sex.MALE)
				.teachername(Teacher.Zeynep)
				.birthDate(1997)
				.build();

		Student student4 = Student.builder()
				.id("126")
				.name("Zeynep")
				.surname("Kartal")
				.sex(Sex.FEMALE)
				.birthDate(2000)
				.teachername(Teacher.Talha)
				.build();

	studentRepository.saveAll(Arrays.asList(student,student1,student2,student3,student4));
	}



}
