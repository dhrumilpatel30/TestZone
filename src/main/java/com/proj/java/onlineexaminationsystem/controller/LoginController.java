package com.proj.java.onlineexaminationsystem.controller;

import com.proj.java.onlineexaminationsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.event.PaintEvent;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private StudentService studentService;

    @RequestMapping ("/student")
    public String doLoginStudent(){
        return "student/login_page";
    }
    @RequestMapping("/teacher")
    public String doLoginTeacher(){
        return "teacher/login_page";
    }
    @PostMapping("student")
    public String checkStudent(@RequestParam(value = "student_id", required = true) int student_id,
                               @RequestParam(value = "dateofbirth", required = true) String dateofbirth, ModelMap studentModel){
//        studentModel.addAttribute("msg",student_id+dateofbirth);
//        if(studentService.validate(student_id,dateofbirth).equals("success")){
//
//        }
//        else{
//            studentModel.addAttribute("msg",studentService.validate(student_id,dateofbirth));
//        }
        return "student/home_page";
    }
    @PostMapping("teacher")
    public String checkTeacher(@RequestParam(value = "student_id", required = true) int student_id,
                               @RequestParam(value = "dateofbirth", required = true) String dateofbirth, ModelMap teacherModel){
//        teacherModel.addAttribute("msg",student_id+dateofbirth);
//        if(teacherService.validate(teacher_id,dateofbirth).equals("success")){
//
//        }
//        else{
//            teacherModel.addAttribute("msg",teacherService.validate(teacher_id,dateofbirth));
//        }
        return "teacher/home_page";
    }
}
