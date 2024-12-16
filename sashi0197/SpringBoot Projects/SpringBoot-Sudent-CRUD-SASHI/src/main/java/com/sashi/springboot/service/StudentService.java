package com.sashi.springboot.service;

import java.util.List;

import com.sashi.springboot.entities.Student;



public interface StudentService {
	Student createStudent(Student std);
	Student findStudentById(int St_id);
	Student updateStudent(Student emp);
	List<Student> findAllStudents();
	void deleteStudent(int St_id);
}
