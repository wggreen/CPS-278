package edu.wccnet.wggreen.studentApp.Service;

import java.util.List;

import edu.wccnet.wggreen.studentApp.entity.Student;

public interface StudentService {

	public List<Student> getStudents();

	public void saveStudent(Student theStudent);

	public Student getStudent(int id);

	public void deleteStudent(int id);

}
