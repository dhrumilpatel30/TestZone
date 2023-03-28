package com.proj.java.onlineexaminationsystem.controller;


import com.proj.java.onlineexaminationsystem.entity.Quiz;
import com.proj.java.onlineexaminationsystem.entity.Score;
import com.proj.java.onlineexaminationsystem.service.QuizService;
import com.proj.java.onlineexaminationsystem.service.ScoreService;
import com.proj.java.onlineexaminationsystem.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/exam")
public class ExamController{
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private QuizService quizService;
	@GetMapping("/{id}")
	public String getExam(HttpServletRequest request, @PathVariable int id, ModelMap examModel) {
        HttpSession session = request.getSession();
        if(!session.isNew() && session.getAttribute("role") != null){
            if(session.getAttribute("role").equals("student")) {
                List<Score> scoreList = scoreService.getExamQuestions((int)session.getAttribute("id"),id);
                examModel.addAttribute("scores", scoreList);
                examModel.addAttribute("quiz",quizService.getQuiz(id));
                return "exam/exampage";
            }
		}
        return "redirect:/";
	}
//	@GetMapping("/addQuiz")
//	public String addQuiz(HttpServletRequest request, ModelMap quizModel) {
//		HttpSession session = request.getSession();
//		if(!session.isNew() && session.getAttribute("role").equals("teacher")){
//			Quiz quiz = new Quiz();
//			quizService.addQuiz(quiz);
//			quizModel.addAttribute("quiz", quiz);
//			return "quiz/update_form";
//		}
//		return "redirect:/";
//	}
//	@GetMapping("/update/{id}")
//	public String updatePage(@PathVariable("id") int id, ModelMap quizModel) {
//		quizModel.addAttribute("id", id);
//		Quiz quiz = quizService.getQuiz(id);
//		quizModel.addAttribute("quiz", quiz);
//		return "quiz/update_form";
//	}
//
//	@PostMapping("/update")
//	public String updateQuiz(@ModelAttribute("quiz") Quiz quiz, HttpServletRequest request, ModelMap quizModel) {
//		HttpSession session = request.getSession();
//		if(!session.isNew() && session.getAttribute("role").equals("teacher")) {
//			int id = (int) session.getAttribute("id");
//			quiz.setTeacher_id(teacherService.getTeacher(id));
//			quizService.updateQuiz(quiz);
//		}
//		return "redirect:/";
//	}
//
//	@GetMapping("/delete/{id}")
//	public String deleteQuiz(@PathVariable int id, HttpServletRequest request, ModelMap quizModel) {
//		HttpSession session = request.getSession();
//		if(!session.isNew() && session.getAttribute("role").equals("teacher")){
//			quizService.deleteQuiz(id);
//		}return "redirect:/";
//	}
}
