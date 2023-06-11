package com.proj.java.onlineexaminationsystem.service;

import com.proj.java.onlineexaminationsystem.entity.Question;
import com.proj.java.onlineexaminationsystem.entity.Quiz;
import com.proj.java.onlineexaminationsystem.repository.QuizDAO;
import com.proj.java.onlineexaminationsystem.repository.TeacherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizDAO quizDAO;
    @Autowired
    private TeacherDAO teacherDAO;

    public Quiz getQuiz(final int id) {
        return quizDAO.getQuiz(id);
    }

    public List<Quiz> getQuizs() {
        return quizDAO.getQuizs();
    }

    public void addQuiz(final Quiz quiz) {
        quizDAO.addQuiz(quiz);
    }

    public void updateQuiz(final Quiz quiz) {
        quizDAO.updateQuiz(quiz);
    }

    public void deleteQuiz(final int id) {
        quizDAO.deleteQuiz(id);
    }

    public void updateQuizMarks(int quiz_id) {
        Quiz quiz = quizDAO.getQuiz(quiz_id);
        int total_marks = 0;
        for (Question q : quiz.getQuestions()) {
            total_marks = total_marks + q.getMax_marks();
        }
        quiz.setTotal_max_marks(total_marks);
        quizDAO.updateQuiz(quiz);
    }

    public List<Quiz> getTeacherQuizes(final int teacher_id) {
        List<Quiz> quizzes = teacherDAO.getTeacher(teacher_id).getQuiz();

        List<Quiz> quizList = new ArrayList<>();
        for (Quiz q : quizzes) {
            if (!q.isIspublished()) quizList.add(q);
        }
        return quizList;
    }

    public List<Quiz> getTeacherPublishedQuizes(final int teacher_id) {
        List<Quiz> quizzes = teacherDAO.getTeacher(teacher_id).getQuiz();

        List<Quiz> quizList = new ArrayList<>();
        for (Quiz q : quizzes) {
            if (q.isIspublished()) quizList.add(q);
        }
        return quizList;
    }

    public List<Quiz> getNonTeacherQuizes(final int teacher_id) {
        List<Quiz> quizzes = getQuizs();
        for (Quiz q : teacherDAO.getTeacher(teacher_id).getQuiz()) {
            quizzes.remove(q);
        }
        Iterator<Quiz> quizIterator = quizzes.listIterator();
        while (quizIterator.hasNext()) {
            if (!quizIterator.next().isIspublished()) quizIterator.remove();
        }
        return quizzes;
    }
}