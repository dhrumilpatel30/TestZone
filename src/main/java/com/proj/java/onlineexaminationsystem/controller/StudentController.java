package com.proj.java.onlineexaminationsystem.controller;

import com.proj.java.onlineexaminationsystem.entity.Student;
import com.proj.java.onlineexaminationsystem.service.QuizService;
import com.proj.java.onlineexaminationsystem.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    QuizService quizService;

    @RequestMapping("")
    public String showPage(HttpServletRequest request, ModelMap model) {
        HttpSession session = request.getSession();
        if (session.getAttribute("role") != null) {
            if (!session.getAttribute("role").equals("student")) return "redirect:/";
        }
        if (session.getAttribute("success") != null) {
            model.addAttribute("success", session.getAttribute("success"));
            session.removeAttribute("success");
        }
        int student_id = (int) session.getAttribute("id");
        Student student = studentService.getStudent(student_id);
        model.addAttribute("quizzesCompleted", studentService.getCompletedQuizzes(student));
        model.addAttribute("quizzesPending", studentService.getPendingQuizzes(student));
        return "student/home_page";
    }

    @PostMapping("login")
    public String checkStudent(@RequestParam(value = "email", required = true) String email,
                               @RequestParam(value = "password", required = true) String password, HttpServletRequest request, ModelMap model) {

        if (!studentService.login(email, password)) {
            model.addAttribute("error", "Wrong credentials !!");
            return "student/login_page";
        }
        Student student = studentService.getStudentByEmail(email);
        HttpSession session = request.getSession();
        session.setAttribute("role", "student");
        session.setAttribute("id", student.getId());
        session.setAttribute("success", "Logged in SuccessFull Welcome");
        return "redirect:/";
    }

    @GetMapping("login")
    public String loginGet(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("role") != null) {
            return "redirect:/";
        }
        session.invalidate();
        return "student/login_page";
    }

    @PostMapping("signup")
    public String registerStudent(@ModelAttribute("student") Student student, ModelMap model) {
        studentService.addStudent(student);
        model.addAttribute("success", "Account Created Successfully");
        return "/student/login_page";
    }

    @GetMapping("signup")
    public String RegisterGet(ModelMap model) {
        Student stu = new Student();
        model.addAttribute("student", stu);
        return "student/signup";
    }

}
