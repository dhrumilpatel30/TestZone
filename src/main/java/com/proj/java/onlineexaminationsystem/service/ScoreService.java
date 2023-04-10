package com.proj.java.onlineexaminationsystem.service;

import com.proj.java.onlineexaminationsystem.entity.*;
import com.proj.java.onlineexaminationsystem.repository.QuizDAO;
import com.proj.java.onlineexaminationsystem.repository.ScoreDAO;
import com.proj.java.onlineexaminationsystem.repository.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreService {

    @Autowired
    private ScoreDAO scoreDAO;
    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private QuizDAO quizDAO;

    public Score getScore(final int id) {
        return scoreDAO.getScore(id);
    }

    public List<Score> getScores() {
        return scoreDAO.getScores();
    }

    public void addScore(final Score score) {
        scoreDAO.addScore(score);
    }

    public void updateScore(final Score score) {
        scoreDAO.updateScore(score);
    }

    public void deleteScore(final int id) {
        scoreDAO.deleteScore(id);
    }

    public List<Score> getExamQuestions(final int student_id, final int quiz_id) {
        Student student = studentDAO.getStudent(student_id);
        Quiz quiz = quizDAO.getQuiz(quiz_id);
        List<Question> questions = quiz.getQuestions();
        List<Score> scores = new ArrayList<>();
        for (Question q : questions) {
//			System.out.println("\n\n\n\n\\n\\n\n\n\n\n\n\n\\n\n\n\n"+q+"\n\n\n\n\n\n\n\n\n\n\n");
            Score s = new Score();
            s.setQuestion_id(q);
            s.setQuiz_id(quiz);
            s.setStudent_id(student);
            s.setScore("0");
            s.setChoosen_answer("0");
            scoreDAO.addScore(s);
            scores.add(scoreDAO.getScore(s.getScore_id()));
        }
        return scores;
    }

    public Result getResult(List<Score> scores) {
        Result result = new Result();
        result.setResult(0);
        Score s1;
        for (Score s : scores) {
            s1 = scoreDAO.getScore(s.getScore_id());

            s1.setChoosen_answer(s.getChoosen_answer());
            if (s.getChoosen_answer() == null) s1.setChoosen_answer("0");
            if (s1.getQuestion_id().getCorrect_answer().equals(s1.getChoosen_answer())) {
                s1.setScore(String.valueOf(s1.getQuestion_id().getMax_marks()));
            } else {
                s1.setScore("0");
            }
            scoreDAO.updateScore(s1);
            result.setResult(Integer.parseInt(s1.getScore()) + result.getResult());
        }
        Score s = scoreDAO.getScore(scores.get(0).getScore_id());
        result.setStudent_id(s.getStudent_id());
        result.setQuiz_id(s.getQuiz_id());
        return result;
    }

    public List<Score> getResultScores(final int student_id, final int quiz_id) {
        Student student = studentDAO.getStudent(student_id);
        Quiz quiz = quizDAO.getQuiz(quiz_id);
        return scoreDAO.getScoresByStudent(student, quiz);
    }

}