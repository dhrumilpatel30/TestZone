package com.proj.java.onlineexaminationsystem.controller;

import com.proj.java.onlineexaminationsystem.entity.Quiz;
import com.proj.java.onlineexaminationsystem.entity.Student;
import com.proj.java.onlineexaminationsystem.entity.Teacher;
import com.proj.java.onlineexaminationsystem.service.QuizService;
import com.proj.java.onlineexaminationsystem.service.StudentService;
import com.proj.java.onlineexaminationsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private  QuizService quizService;

    @RequestMapping("/student")
    public String doLoginStudent(){
        return "student/login_page";
    }
    @RequestMapping("/teacher")
    public String doLoginTeacher(){
        return "teacher/login_page";
    }
    @PostMapping("student")
    public String checkStudent(@RequestParam(value = "student_id", required = true) String student_id,
                               @RequestParam(value = "dateofbirth", required = true) String dateofbirth, ModelMap studentModel){
//        studentModel.addAttribute("msg",student_id+dateofbirth);
//        if(studentService.validate(student_id,dateofbirth).equals("success")){
//
//        }
//        else{
//            studentModel.addAttribute("msg",studentService.validate(student_id,dateofbirth));
//        }
        int student_id1 = Integer.parseInt(student_id);
        Student student = studentService.getStudent(student_id1);
        studentModel.addAttribute("quizzes",quizService.getQuizs());
        studentModel.addAttribute("studentName",student.getName());
        return "student/home_page";
    }
    @PostMapping("teacher")
    public String checkTeacher(@RequestParam(value = "teacher_id", required = true) int teacher_id,
                               @RequestParam(value = "dateofbirth", required = true) String dateofbirth, ModelMap teacherModel){

//        Teacher teacher = teacherService.getTeacher(teacher_id);
        return "teacher/home_page";

    }
}
