package com.proj.java.onlineexaminationsystem.repository;

import com.proj.java.onlineexaminationsystem.entity.Question;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.query.MutationQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class QuestionDAO {

    private EntityManager entityManager;

    @Autowired
    public QuestionDAO(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    public Question getQuestion(final int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Question question = currentSession.get(Question.class, id);
        currentSession.close();
        return question;
    }

    public List<Question> getQuestions() {
        Session currentSession = entityManager.unwrap(Session.class);

        TypedQuery<Question> theQuery = currentSession.createQuery("from Question", Question.class);
        List<Question> quetions = theQuery.getResultList();

        currentSession.close();
        return quetions;
    }

    @Transactional
    public void addQuestion(final Question question) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.persist(question);
        currentSession.close();
    }

    @Transactional
    public void updateQuestion(final Question question) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.merge(question);
        currentSession.close();
    }

    @Transactional
    public void deleteQuestion(final int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Question question = currentSession.get(Question.class, id);
        MutationQuery theQuery = currentSession.createMutationQuery("delete Question where question_id =:i");
        theQuery.setParameter("i", id);
        theQuery.executeUpdate();
        currentSession.close();
    }
}

