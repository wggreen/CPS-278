package edu.wccnet.wggreen.studentApp.Controller;

public class StudentNotFoundException extends RuntimeException {
	public StudentNotFoundException(String msg) {
		super(msg);
	}
}
