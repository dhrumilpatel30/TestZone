package com.proj.java.onlineexaminationsystem.controller;

import java.util.List;

import com.proj.java.onlineexaminationsystem.entity.Quiz;
import com.proj.java.onlineexaminationsystem.service.QuizService;
import com.proj.java.onlineexaminationsystem.service.TeacherService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	@Autowired
	private TeacherService teacherService;
	@GetMapping("/{id}")
	public String getQuiz(@PathVariable int id, ModelMap quizModel) {
		Quiz quiz = quizService.getQuiz(id);
		quizService.updateQuizMarks(id);
		quizModel.addAttribute("quiz", quiz);
		quizModel.addAttribute("questions",quiz.getQuestions());
		return "quiz/home_page";
	}
	@GetMapping("/addQuiz")
	public String addQuiz(HttpServletRequest request, ModelMap quizModel) {
		HttpSession session = request.getSession();
		if(!session.isNew() && session.getAttribute("role").equals("teacher")){
			Quiz quiz = new Quiz();
			quizService.addQuiz(quiz);
			quizModel.addAttribute("quiz", quiz);
			return "quiz/update_form";
		}
		return "redirect:/";
	}
	@GetMapping("/update/{id}")
	public String updatePage(@PathVariable("id") int id, ModelMap quizModel) {
		quizModel.addAttribute("id", id);
		Quiz quiz = quizService.getQuiz(id);
		quizModel.addAttribute("quiz", quiz);
		return "quiz/update_form";
	}

	@PostMapping("/update")
	public String updateQuiz(@ModelAttribute("quiz") Quiz quiz, HttpServletRequest request, ModelMap quizModel) {
		HttpSession session = request.getSession();
		if(!session.isNew() && session.getAttribute("role").equals("teacher")) {
			int id = (int) session.getAttribute("id");
			quiz.setTeacher_id(teacherService.getTeacher(id));
			quizService.updateQuiz(quiz);
		}
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteQuiz(@PathVariable int id, HttpServletRequest request, ModelMap quizModel) {
		HttpSession session = request.getSession();
		if(!session.isNew() && session.getAttribute("role").equals("teacher")){
			quizService.deleteQuiz(id);
		}return "redirect:/";
	}
}
