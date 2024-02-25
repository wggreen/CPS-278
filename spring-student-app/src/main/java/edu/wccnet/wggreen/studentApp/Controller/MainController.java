package edu.wccnet.wggreen.studentApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.wccnet.wggreen.studentApp.Service.StudentService;
import edu.wccnet.wggreen.studentApp.entity.Student;

@Controller
@RequestMapping("/student")
public class MainController {

	@Autowired
	private StudentService studentService;
	// private StudentDAO studentDAO;

	@GetMapping("/list")
	public String listStudents(Model model) {

		model.addAttribute("students", studentService.getStudents());

		return "list-students";
	}

	@PostMapping("/addStudent")
	public String addStudent(Model model) {
		Student student = new Student();

		model.addAttribute("student", student);

		return "add-student";
	}

	@PostMapping("/processStudent")
	public String processStudent(@ModelAttribute("student") Student theStudent) {
		System.out.println(theStudent);
		studentService.saveStudent(theStudent);

		return "redirect:/student/list";
	}

	@RequestMapping("/updateStudent")
	public String updateStudent(Model model, @RequestParam("studentId") int id) {
		Student student = studentService.getStudent(id);
		
		model.addAttribute("student", student);
		
		return "add-student";
	}
	
	@RequestMapping("/deleteStudent")
	public String deleteStudent(Model model, @RequestParam("studentId") int id) {
		
		studentService.deleteStudent(id);
				
		return "redirect:/student/list";
	}

}
