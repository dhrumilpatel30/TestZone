package com.proj.java.onlineexaminationsystem.controller;


import com.proj.java.onlineexaminationsystem.entity.Quiz;
import com.proj.java.onlineexaminationsystem.entity.Result;
import com.proj.java.onlineexaminationsystem.service.QuizService;
import com.proj.java.onlineexaminationsystem.service.ResultService;
import com.proj.java.onlineexaminationsystem.service.ScoreService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/result")
public class ResultController {
    @Autowired
    private ResultService resultService;
    @Autowired
    private QuizService quizService;
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/{id}")
    public String getExam(HttpServletRequest request, @PathVariable int id, ModelMap resultModel) {
        HttpSession session = request.getSession();
        if (!session.isNew() && session.getAttribute("role") != null) {
            if (session.getAttribute("role").equals("teacher")) {
                Quiz quiz = quizService.getQuiz(id);
                resultModel.addAttribute("resultPassed", resultService.getPassResults(quiz));
                resultModel.addAttribute("resultFailed", resultService.getFailResults(quiz));
                resultModel.addAttribute("quiz", quiz);
                return "result/viewresults";
            }
        }
        return "redirect:/";
    }

    @RequestMapping("/studentResult/{id}")
    public String showResult(HttpServletRequest request, ModelMap resultModel, @PathVariable int id) {
        HttpSession session = request.getSession();
        if (!session.isNew() && session.getAttribute("role") != null) {
            if (session.getAttribute("role").equals("teacher")) {
                Result result = resultService.getResult(id);
                resultModel.addAttribute("result", result);
                resultModel.addAttribute("scores", scoreService.getResultScores(result.getStudent_id().getId(), result.getQuiz_id().getQuiz_id()));
                return "exam/showResult";
            }
        }
        return "redirect:/";
    }
}
