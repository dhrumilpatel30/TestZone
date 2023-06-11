package com.proj.java.onlineexaminationsystem.controller;

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
        if (!session.isNew() && session.getAttribute("role").equals("teacher")) {
            Question question = new Question();
            question.setQuiz_id(quizService.getQuiz(id));
            questionService.addQuestion(question);
            questionModel.addAttribute("question", question);
            session.setAttribute("quiz_id", quizService.getQuiz(id));
            return "question/update_form";
        }
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable("id") int id, ModelMap questionModel, HttpServletRequest request) {
        HttpSession session = request.getSession();
        questionModel.addAttribute("id", id);
        Question question = questionService.getQuestion(id);
        questionModel.addAttribute("question", question);
        session.setAttribute("quiz_id", question.getQuiz_id());
        return "question/update_form";
    }

    @PostMapping("/update")
    public String updateQuiz(@ModelAttribute("question") Question question, HttpServletRequest request, ModelMap questionModel) {
        HttpSession session = request.getSession();
        if (!session.isNew() && session.getAttribute("role").equals("teacher")) {
            question.setQuiz_id((Quiz) session.getAttribute("quiz_id"));
            questionService.updateQuestion(question);
            int quiz_id = question.getQuiz_id().getQuiz_id();
            session.removeAttribute("quiz_id");
            return "redirect:/quiz/" + quiz_id;
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteQuiz(@PathVariable int id, HttpServletRequest request, ModelMap questionModel) {
        HttpSession session = request.getSession();
        int quiz_id = questionService.getQuestion(id).getQuiz_id().getQuiz_id();
        if (!session.isNew() && session.getAttribute("role").equals("teacher")) {
            if (questionService.getQuestion(id).getQuiz_id().getTeacher_id().getId() == (Integer) session.getAttribute("id")) {
                questionService.deleteQuestion(id);
            }

        }
        return "redirect:/quiz/" + quiz_id;
    }
}
