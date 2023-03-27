package com.proj.java.onlineexaminationsystem.controller;

import com.proj.java.onlineexaminationsystem.entity.Quiz;
import com.proj.java.onlineexaminationsystem.entity.Student;
import com.proj.java.onlineexaminationsystem.service.QuizService;
import com.proj.java.onlineexaminationsystem.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	@Autowired
	QuizService quizService;
	
    @RequestMapping("")
    public String showPage(ModelMap model) {
    	List<Quiz> quizzes = quizService.getQuizs();
    	model.addAttribute("quizzes", quizzes);
    	return "student/home_page";
    }
    
    @PostMapping("login")
    public String checkStudent(@RequestParam(value = "email", required = true) String email,
                               @RequestParam(value = "password", required = true) String password,HttpServletRequest request, ModelMap model){
        
        if(studentService.login(email,password)){
        	HttpSession session = request.getSession();
        	session.setAttribute("role", "student");
        	model.addAttribute("success", "Login Successfully");
        }
        else{
        	model.addAttribute("error", "Wrong credentials !!");
        	return "student/login_page";
        }
        Student student = studentService.getStudentByEmail(email);
    	model.addAttribute("quizzesCompleted", studentService.getCompletedQuizzes(student));
    	model.addAttribute("quizzesPending", studentService.getPendingQuizzes(student));
        model.addAttribute("success","Welcome "+student.getName());
        return "student/home_page";
    }
    
    @GetMapping("login")
    public String loginGet() {
    	return "student/login_page";
    }
    
    @PostMapping("signup")
    public String registerStudent(@ModelAttribute("student") Student student, ModelMap model) {
    	studentService.addStudent(student);
//    	List<Student> students = studentService.getStudents();
//    	model.addAttribute("students", students);
    	model.addAttribute("success","Account Created Successfully");
    	return "/student/login_page";
    }
    @GetMapping("signup")
    public String RegisterGet(ModelMap model) {
    	Student stu = new Student();
    	model.addAttribute("student", stu);
    	return "student/signup";
    }

}
