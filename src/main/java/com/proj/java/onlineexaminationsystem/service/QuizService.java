package com.proj.java.onlineexaminationsystem.service;

import com.proj.java.onlineexaminationsystem.entity.Question;
import com.proj.java.onlineexaminationsystem.entity.Quiz;
import com.proj.java.onlineexaminationsystem.repository.QuestionDAO;
import com.proj.java.onlineexaminationsystem.repository.QuizDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

	@Autowired
	private QuizDAO quizDAO;

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

	public void updateQuizMarks(int quiz_id){
		Quiz quiz = quizDAO.getQuiz(quiz_id);
		int total_marks=0;
		for(Question q : quiz.getQuestions()){
				total_marks = total_marks + q.getMax_marks();
		}
		quiz.setTotal_max_marks(total_marks);
		quizDAO.updateQuiz(quiz);
	}

}