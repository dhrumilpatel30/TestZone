package com.proj.java.onlineexaminationsystem.service;

import com.proj.java.onlineexaminationsystem.entity.Quiz;
import com.proj.java.onlineexaminationsystem.entity.Result;
import com.proj.java.onlineexaminationsystem.entity.Student;
import com.proj.java.onlineexaminationsystem.repository.QuizDAO;
import com.proj.java.onlineexaminationsystem.repository.ResultDAO;
import com.proj.java.onlineexaminationsystem.repository.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

	@Autowired
	private ResultDAO resultDAO;
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private QuizDAO quizDAO;

	public Result getResult(final int id) {
		return resultDAO.getResult(id);
	}

	public List<Result> getResults() {
		return resultDAO.getResults();
	}

	public void addResult(final Result result) {
		resultDAO.addResult(result);
	}

	public void updateResult(final Result result) {
		resultDAO.updateResult(result);
	}

	public void deleteResult(final int id) {
		resultDAO.deleteResult(id);
	}

	public Result getResultByStudent(final int student_id,final int quiz_id) {
		Student student = studentDAO.getStudent(student_id);
		Quiz quiz = quizDAO.getQuiz(quiz_id);
		return resultDAO.getResultByStudent(student,quiz);
	}
}