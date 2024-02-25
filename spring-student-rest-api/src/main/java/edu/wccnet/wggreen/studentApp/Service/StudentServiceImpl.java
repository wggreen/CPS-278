package edu.wccnet.wggreen.studentApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.wggreen.studentApp.Controller.StudentNotFoundException;
import edu.wccnet.wggreen.studentApp.dao.StudentDAO;
import edu.wccnet.wggreen.studentApp.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	@Transactional
	public List<Student> getStudents() {
		return studentDAO.getStudents();
	}
	
	@Override
	@Transactional
	public void saveStudent(Student theStudent) {
		studentDAO.saveStudent(theStudent);
	}

	@Override
	@Transactional
	public Student getStudent(int id) {
		Student student = studentDAO.getStudent(id);
		
		if (student == null) {
			throw new StudentNotFoundException("student id not found. Id: " + id);
		}
		
		return studentDAO.getStudent(id);
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		
		Student student = studentDAO.getStudent(id);
		
		if (student == null) {
			throw new StudentNotFoundException("student id not found. Id: " + id);
		}
		
		studentDAO.deleteStudent(id);
	}

}
