package com.sashi.springboot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sashi.springboot.entities.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class StudentDaoImpl implements StudentDao{
	
	@PersistenceContext
	EntityManager em;
	@Override
	public Student createStudent(Student std) {
		return em.merge(std);
	}

	@Override
	public Student findStudentById(int St_id) {
		return em.find(Student.class, St_id);
	}

	@Override
	public Student updateStudent(Student std) {
		Student student = findStudentById(std.getSt_id());
		student.setName(std.getName());
		student.setAge(std.getAge());
		student = em.merge(student);
		return student;
	}

	@Override
	public List<Student> findAllStudents() {
		Query q = em.createQuery("Select e from Student e");
		List<Student> list = q.getResultList();
		return list;
	}

	@Override
	public void deleteStudent(int St_id) {
		Student student = em.find(Student.class,St_id);
		em.remove(student);
	}

}
