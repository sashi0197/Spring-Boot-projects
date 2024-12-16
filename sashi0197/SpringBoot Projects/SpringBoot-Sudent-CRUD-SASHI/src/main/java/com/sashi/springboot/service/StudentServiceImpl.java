package com.sashi.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sashi.springboot.dao.StudentDao;
import com.sashi.springboot.entities.Student;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDao dao;
	@Override
	public Student createStudent(Student std) {
		return dao.createStudent(std);
	}

	@Override
	public Student findStudentById(int St_id) {
		return dao.findStudentById(St_id);
	}

	@Override
	public Student updateStudent(Student emp) {
		return dao.updateStudent(emp);
	}

	@Override
	public List<Student> findAllStudents() {
		return dao.findAllStudents();
	}

	@Override
	public void deleteStudent(int St_id) {
		dao.deleteStudent(St_id);
	}

}
