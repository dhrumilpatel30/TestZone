package com.proj.java.onlineexaminationsystem.controller;

import java.util.List;

import com.proj.java.onlineexaminationsystem.entity.Quiz;
import com.proj.java.onlineexaminationsystem.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;

	@GetMapping("/{id}")
	public String getQuiz(@PathVariable int id, ModelMap quizModel) {
		Quiz quiz = quizService.getQuiz(id);
		quizModel.addAttribute("quiz", quiz);
		return "quiz/home_page";
	}

	@GetMapping("addQuiz")
	public String addPage() {
		return "add";
	}

	@PostMapping("/add")
	public String addQuiz(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "expertise", required = true) String expertise, ModelMap quizModel) {
		Quiz quiz = new Quiz();
		quizService.addQuiz(quiz);
		quizModel.addAttribute("msg", "Quiz added successfully");
		List<Quiz> quizs = quizService.getQuizs();
		quizModel.addAttribute("quizs", quizs);
		return "redirect:/quizs";
	}

	@GetMapping("update/{id}")
	public String updatePage(@PathVariable("id") int id, ModelMap quizModel) {
		quizModel.addAttribute("id", id);
		Quiz quiz = quizService.getQuiz(id);
		quizModel.addAttribute("quiz", quiz);
		return "update";
	}

	@PostMapping("/update")
	public String updateQuiz(@RequestParam int id, @RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "expertise", required = true) String expertise, ModelMap quizModel) {
		Quiz quiz = new Quiz(id,name,expertise);
		/*
		 * quiz.setId(id); quiz.setName(name); quiz.setExpertise(expertise);
		 */
		quizService.updateQuiz(quiz);
		List<Quiz> quizs = quizService.getQuizs();
		quizModel.addAttribute("quizs", quizs);
		quizModel.addAttribute("id", id);
		quizModel.addAttribute("msg", "Quiz updated successfully");
		return "redirect:/quizs";
	}

	@GetMapping("/delete/{id}")
	public String deleteQuiz(@PathVariable int id, ModelMap quizModel) {
		quizService.deleteQuiz(id);
		List<Quiz> quizs = quizService.getQuizs();
		quizModel.addAttribute("quizs", quizs);
		quizModel.addAttribute("msg", "Quiz delted successfully");
		return "redirect:/quizs";
	}

}
