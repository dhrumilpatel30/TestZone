package com.proj.java.onlineexaminationsystem.service;

import com.proj.java.onlineexaminationsystem.entity.Question;
import com.proj.java.onlineexaminationsystem.repository.QuestionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionDAO questionDAO;

    public Question getQuestion(final int id) {
        return questionDAO.getQuestion(id);
    }

    public List<Question> getQuestions() {
        return questionDAO.getQuestions();
    }

    public void addQuestion(final Question question) {
        questionDAO.addQuestion(question);
    }

    public void updateQuestion(final Question question) {
        questionDAO.updateQuestion(question);
    }

    public void deleteQuestion(final int id) {
        questionDAO.deleteQuestion(id);
    }

}