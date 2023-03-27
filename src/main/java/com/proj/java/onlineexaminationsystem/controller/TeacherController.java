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
    public String showPage(ModelMap model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("role") != null) {
            if(!session.getAttribute("role").equals("teacher"))return "redirect:/";
        }
    	List<Quiz> quizzes = quizService.getQuizs();
//        System.out.println(quizzes);
    	model.addAttribute("quizzes", quizzes);
    	return "teacher/home_page";
    }
    
    @PostMapping("login")
    public String checkTeacher(@RequestParam(value = "email", required = true) String email,
                               @RequestParam(value = "password", required = true) String password,HttpServletRequest request, ModelMap model){
        Teacher teacher = teacherService.login(email,password);
        if(teacher == null){
        	model.addAttribute("error", "Wrong credentials !!");
        	return "teacher/login_page";
        }
        HttpSession session = request.getSession();
        session.setAttribute("role", "teacher");
        session.setAttribute("id",teacher.getId());
        model.addAttribute("success", "Logged in Successfully");
        List<Quiz> quizzes = quizService.getQuizs();
    	model.addAttribute("quizzes", quizzes);
        return "teacher/home_page";
    }
    
    @GetMapping("login")
    public String loginGet() {
    	
    	return "teacher/login_page";
    }
    
    @PostMapping("signup")
    public String registerTeacher(@ModelAttribute("teacher") Teacher teacher, ModelMap model) {
    	teacherService.addTeacher(teacher);
    	
    	model.addAttribute("success","Account Created Successfully");
    	return "/teacher/login_page";
    }
    @GetMapping("signup")
    public String registerGet(ModelMap model) {
    	Teacher stu = new Teacher();
    	model.addAttribute("teacher", stu);
    	return "teacher/signup";
    }

}
