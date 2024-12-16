package com.sashi.springboot.dao;

import java.util.List;

import com.sashi.springboot.entities.Student;

public interface StudentDao {
	Student createStudent(Student std);
	Student findStudentById(int St_id);
	Student updateStudent(Student emp);
	List<Student> findAllStudents();
	void deleteStudent(int St_id);
}
