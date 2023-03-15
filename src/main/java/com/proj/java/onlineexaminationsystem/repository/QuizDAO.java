package com.proj.java.onlineexaminationsystem.repository;

import com.proj.java.onlineexaminationsystem.entity.Quiz;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public class QuizDAO {

	private EntityManager entityManager;

	@Autowired
	public QuizDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	public Quiz getQuiz(final int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Quiz quiz = currentSession.get(Quiz.class, id);
		currentSession.close();
		return quiz;
	}
//	public boolean validate(int quiz_id,String date_of_birth){
//		Session currentSession = entityManager.unwrap(Session.class);
//		TypedQuery<Quiz> theQuery = currentSession.createQuery("from Quiz where person_id = ? and date_of_birth = ?", Quiz.class);
//		theQuery.
//		List<Quiz> quizs = theQuery.getResultList();
//		return false;
//	}
	public List<Quiz> getQuizs() {
		Session currentSession = entityManager.unwrap(Session.class);
		TypedQuery<Quiz> theQuery = currentSession.createQuery("from Quiz", Quiz.class);
		List<Quiz> quizs = theQuery.getResultList();
		currentSession.close();
		return quizs;
	}
	@Transactional
	public void addQuiz(final Quiz quiz) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.persist(quiz);
		currentSession.close();
	}

	@Transactional
	public void updateQuiz(final Quiz quiz) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.merge(quiz);
		currentSession.close();
	}

	@Transactional
	public void deleteQuiz(final int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Quiz quiz = currentSession.get(Quiz.class, id);
		currentSession.remove(quiz);
		currentSession.close();

	}
}

