package com.proj.java.onlineexaminationsystem.repository;

import com.proj.java.onlineexaminationsystem.entity.Quiz;
import com.proj.java.onlineexaminationsystem.entity.Result;
import com.proj.java.onlineexaminationsystem.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ResultDAO {

    private EntityManager entityManager;

    @Autowired
    public ResultDAO(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    public Result getResult(final int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Result result = currentSession.get(Result.class, id);
        currentSession.close();
        return result;
    }

    public List<Result> getResults() {
        Session currentSession = entityManager.unwrap(Session.class);

        TypedQuery<Result> theQuery = currentSession.createQuery("from Result", Result.class);
        List<Result> results = theQuery.getResultList();

        currentSession.close();
        return results;
    }

    @Transactional
    public void addResult(final Result result) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.persist(result);
        currentSession.close();
    }

    @Transactional
    public void updateResult(final Result result) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.merge(result);
        currentSession.close();
    }

    @Transactional
    public void deleteResult(final int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Result result = currentSession.get(Result.class, id);
        currentSession.remove(result);
        currentSession.close();

    }

    @Transactional
    public boolean isResultPresent(Student student, Quiz quiz) {
        Session currentSession = entityManager.unwrap(Session.class);
        TypedQuery<Result> theQuery = currentSession.createQuery("from Result where student_id=:s and quiz_id=:q", Result.class);
        theQuery.setParameter("s", student);
        theQuery.setParameter("q", quiz);
        try {
            theQuery.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional
    public Result getResultByStudent(Student student, Quiz quiz) {
        Session currentSession = entityManager.unwrap(Session.class);
        TypedQuery<Result> theQuery = currentSession.createQuery("from Result where student_id=:s and quiz_id=:q", Result.class);
        theQuery.setParameter("s", student);
        theQuery.setParameter("q", quiz);
        try {
            return theQuery.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}

