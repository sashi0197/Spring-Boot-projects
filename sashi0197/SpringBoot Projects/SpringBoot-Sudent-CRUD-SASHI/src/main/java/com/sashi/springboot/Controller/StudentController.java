package com.sashi.springboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sashi.springboot.dao.StudentNotFoundException;
import com.sashi.springboot.entities.Student;
import com.sashi.springboot.service.StudentService;

@RestController

public class StudentController {
	@Autowired
	private StudentService service;
	
	@PostMapping("/create")
	public ResponseEntity<Boolean> CreateStudent(@RequestBody Student std){
		service.createStudent(std);
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		System.out.println("response entity =" +responseEntity);
		return responseEntity;
	}
	
	@GetMapping(path="/find/St_id")
	public ResponseEntity<Student> findStudentById(@PathVariable int St_id ){
		Student std = service.findStudentById(St_id);
		if(std==null) {
			throw new StudentNotFoundException("Student not found for id = :"+St_id);
		}
		return new ResponseEntity<Student>(std,new HttpHeaders(),HttpStatus.OK);		
	}
	
	@GetMapping(path="/getAll")
	public ResponseEntity<List<Student>> findAll(){
		List<Student> list=service.findAllStudents();
		return new ResponseEntity<List<Student>>(list,new HttpHeaders(),HttpStatus.OK);
	}
	
	@PutMapping(path="/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student std){
		std = service.updateStudent(std);
		return new ResponseEntity<Student>(std,new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping(path="/delete/{St_id}")
	public String deleteStudent(@PathVariable int St_id) {
		service.deleteStudent(St_id);
		return "Deleted";
	}
}
