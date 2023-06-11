package com.proj.java.onlineexaminationsystem.controller;


import com.proj.java.onlineexaminationsystem.entity.Result;
import com.proj.java.onlineexaminationsystem.entity.Score;
import com.proj.java.onlineexaminationsystem.entity.ScoreList;
import com.proj.java.onlineexaminationsystem.service.QuizService;
import com.proj.java.onlineexaminationsystem.service.ResultService;
import com.proj.java.onlineexaminationsystem.service.ScoreService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private QuizService quizService;
    @Autowired
    private ResultService resultService;

    @GetMapping("/{id}")
    public String getExam(HttpServletRequest request, @PathVariable int id, ModelMap examModel) {
        HttpSession session = request.getSession();
        if (!session.isNew() && session.getAttribute("role") != null) {
            if (session.getAttribute("role").equals("student")) {
                if (!resultService.isResultPresent((Integer) session.getAttribute("id"), id)) {
                    List<Score> scoreList = scoreService.getExamQuestions((int) session.getAttribute("id"), id);
                    ScoreList scores = new ScoreList(scoreList);
                    examModel.addAttribute("scores", scores);
                    examModel.addAttribute("quiz", quizService.getQuiz(id));

                    return "exam/exampage";
                }
            }
        }
        return "redirect:/";
    }

    @PostMapping("/calculateResult")
    public String calculateResult(@ModelAttribute("questions") ScoreList scores) {
        Result result = scoreService.getResult(scores.getScores());
        resultService.addResult(result);
        return "redirect:/exam/showResult/" + result.getQuiz_id().getQuiz_id();
    }

    @RequestMapping("/showResult/{id}")
    public String showResult(HttpServletRequest request, ModelMap examModel, @PathVariable int id) {
        HttpSession session = request.getSession();
        if (!session.isNew() && session.getAttribute("role") != null) {
            if (session.getAttribute("role").equals("student")) {
                Result result = resultService.getResultByStudent((Integer) session.getAttribute("id"), id);
                examModel.addAttribute("scores", scoreService.getResultScores((Integer) session.getAttribute("id"), id));
                examModel.addAttribute("result", result);
                if (result.getResult() >= result.getQuiz_id().getPassing_marks()) {
                    examModel.addAttribute("success", "You are Pass in this Quiz");
                } else {
                    examModel.addAttribute("error", "Sorry,You are not pass in this quiz");
                }
                return "exam/showResult";
            }
        }
        return "redirect:/";
    }
}
