package com.proj.java.onlineexaminationsystem.controller;

import com.proj.java.onlineexaminationsystem.entity.Quiz;
import com.proj.java.onlineexaminationsystem.entity.Teacher;
import com.proj.java.onlineexaminationsystem.service.QuizService;
import com.proj.java.onlineexaminationsystem.service.TeacherService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	QuizService quizService;
	
    @RequestMapping("")
    public String showPage(ModelMap model) {
    	List<Quiz> quizs = quizService.getQuizs();
    	model.addAttribute("quizs", quizs);
    	return "teacher/home_page";
    }
    
    @PostMapping("login")
    public String checkStudent(@RequestParam(value = "email", required = true) String email,
                               @RequestParam(value = "password", required = true) String password,HttpServletRequest request, ModelMap model){
        
        if(teacherService.login(email,password)){
        	HttpSession session = request.getSession();
        	session.setAttribute("role", "teacher");
        	model.addAttribute("success", "Login Successfully");
        }
        else{
        	model.addAttribute("error", "Wrong credentials !!");
        	return "teacher/login_page";
        }
        List<Quiz> quizs = quizService.getQuizs();
    	model.addAttribute("quizs", quizs);
        return "teacher/home_page";
    }
    
    @GetMapping("login")
    public String loginGet() {
    	
    	return "teacher/login_page";
    }
    
    @PostMapping("signup")
    public String registerStudent(@ModelAttribute("teacher") Teacher teacher, ModelMap model) {
    	teacherService.addTeacher(teacher);
    	
    	model.addAttribute("success","Acount Created Successfully");
    	return "/teacher/login_page";
    }
    @GetMapping("signup")
    public String RegisterGet(ModelMap model) {
    	Teacher stu = new Teacher();
    	model.addAttribute("teacher", stu);
    	return "teacher/signup";
    }

}
