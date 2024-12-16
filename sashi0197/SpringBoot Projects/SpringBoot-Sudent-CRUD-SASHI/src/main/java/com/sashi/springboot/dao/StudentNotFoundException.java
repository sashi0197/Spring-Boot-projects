package com.sashi.springboot.dao;

public class StudentNotFoundException extends RuntimeException{
	public StudentNotFoundException(String msg) {
		super(msg);
	}
	public StudentNotFoundException(String msg,Throwable e) {
		super(msg, e);
	}
}
