package com.sashi.springboot.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name="StudentTable")
public class Student {
	@Id
	@GeneratedValue
	private int St_id;
	private String name;
	private char grade;
	private short age;
	public int getSt_id() {
		return St_id;
	}
	public void setSt_id(int st_id) {
		St_id = st_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	public short getAge() {
		return age;
	}
	public void setAge(short age) {
		this.age = age;
	}
	
	public Student() {
		super();
	}
	
	@Override
	public String toString() {
		return "Student [St_id=" + St_id + ", name=" + name + ", grade=" + grade + ", age=" + age + "]";
	}
	
	
}
