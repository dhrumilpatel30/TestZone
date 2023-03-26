package com.proj.java.onlineexaminationsystem.controller;

import java.util.List;

import com.proj.java.onlineexaminationsystem.entity.Question;
import com.proj.java.onlineexaminationsystem.entity.Quiz;
import com.proj.java.onlineexaminationsystem.service.QuestionService;
import com.proj.java.onlineexaminationsystem.service.QuizService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuizService quizService;
    @Autowired
    private QuestionService questionService;

	@GetMapping("/addQuestion")
	public String addQuiz(HttpServletRequest request, ModelMap questionModel) {
		HttpSession session = request.getSession();
		if(!session.isNew() && session.getAttribute("role").equals("teacher")){
			Question question = new Question();
			questionModel.addAttribute("question", question);
			return "question/update_form";
		}
		return "redirect:/";
	}
	@GetMapping("/update/{id}")
	public String updatePage(@PathVariable("id") int id, ModelMap questionModel) {
		questionModel.addAttribute("id", id);
		Question question = questionService.getQuestion(id);
		questionService.deleteQuestion(question.getQuestion_id());
		questionModel.addAttribute("question", question);
		return "question/update_form";
	}

	@PostMapping("/update")
	public String updateQuiz(@ModelAttribute("question") Question question, HttpServletRequest request, ModelMap questionModel) {
		HttpSession session = request.getSession();
		if(!session.isNew() && session.getAttribute("role").equals("teacher")) {
			questionService.addQuestion(question);
			questionModel.addAttribute("quiz", question.getQuiz_id());
			questionModel.addAttribute("questions",question.getQuiz_id().getQuestions());
			questionModel.addAttribute("success", "Question updated successfully");
		}
		return "quiz/home_page";
	}
//
//	@GetMapping("/delete/{id}")
//	public String deleteQuiz(@PathVariable int id, HttpServletRequest request, ModelMap quizModel) {
//		HttpSession session = request.getSession();
//		if(!session.isNew() && session.getAttribute("role").equals("teacher")){
//			quizService.deleteQuiz(id);
//			List<Quiz> quizs = quizService.getQuizs();
//			quizModel.addAttribute("quizs", quizs);
//			quizModel.addAttribute("msg", "Quiz deleted successfully");
//		}return "redirect:/";
//	}
}
