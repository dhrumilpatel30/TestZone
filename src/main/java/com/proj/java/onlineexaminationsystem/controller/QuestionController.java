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
    private QuestionService questionService;
    @Autowired
    private QuizService quizService;

	@GetMapping("/addQuestion/{id}")
	public String addQuiz(@PathVariable("id") int id, HttpServletRequest request, ModelMap questionModel) {
		HttpSession session = request.getSession();
		if(!session.isNew() && session.getAttribute("role").equals("teacher")){
			Question question = new Question();
			questionService.addQuestion(question);
			questionModel.addAttribute("question", question);
			session.setAttribute("quiz_id",quizService.getQuiz(id));
			return "question/update_form";
		}
		return "redirect:/";
	}
	@GetMapping("/update/{id}")
	public String updatePage(@PathVariable("id") int id, ModelMap questionModel,HttpServletRequest request) {
		HttpSession session = request.getSession();
		questionModel.addAttribute("id", id);
		Question question = questionService.getQuestion(id);
		questionModel.addAttribute("question", question);
		questionService.deleteQuestion(id);
		session.setAttribute("quiz_id",question.getQuiz_id());
		return "question/update_form";
	}

	@PostMapping("/update")
	public String updateQuiz(@ModelAttribute("question") Question question, HttpServletRequest request, ModelMap questionModel) {
		HttpSession session = request.getSession();
		if(!session.isNew() && session.getAttribute("role").equals("teacher")) {
            question.setQuiz_id((Quiz) session.getAttribute("quiz_id"));
			session.removeAttribute("quiz_id");
			questionService.updateQuestion(question);
			questionModel.addAttribute("quiz", question.getQuiz_id());
			questionModel.addAttribute("questions",question.getQuiz_id().getQuestions());
			questionModel.addAttribute("success", "Question updated successfully");
		}
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteQuiz(@PathVariable int id, HttpServletRequest request, ModelMap questionModel) {
		HttpSession session = request.getSession();
		if(!session.isNew() && session.getAttribute("role").equals("teacher")){
			questionService.deleteQuestion(id);
			List<Question> questions = questionService.getQuestions();
			questionModel.addAttribute("questions", questions);
			questionModel.addAttribute("success", "Question deleted successfully");
		}return "redirect:/quiz/"+questionService.getQuestion(id).getQuiz_id().getQuiz_id();
	}
}
