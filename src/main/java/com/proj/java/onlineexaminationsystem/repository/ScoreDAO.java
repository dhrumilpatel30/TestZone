package com.proj.java.onlineexaminationsystem.repository;

import com.proj.java.onlineexaminationsystem.entity.Quiz;
import com.proj.java.onlineexaminationsystem.entity.Score;
import com.proj.java.onlineexaminationsystem.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ScoreDAO {

    private EntityManager entityManager;

    @Autowired
    public ScoreDAO(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    public Score getScore(final int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Score score = currentSession.get(Score.class, id);
        currentSession.close();
        return score;
    }

    public List<Score> getScores() {
        Session currentSession = entityManager.unwrap(Session.class);

        TypedQuery<Score> theQuery = currentSession.createQuery("from Score", Score.class);
        List<Score> scores = theQuery.getResultList();

        currentSession.close();
        return scores;
    }

    @Transactional
    public void addScore(final Score score) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.persist(score);
        currentSession.close();
    }

    @Transactional
    public void updateScore(final Score score) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.merge(score);
        currentSession.close();
    }

    @Transactional
    public void deleteScore(final int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Score score = currentSession.get(Score.class, id);
        currentSession.remove(score);
        currentSession.close();
    }

    @Transactional
    public List<Score> getScoresByStudent(final Student student, final Quiz quiz) {
        Session currentSession = entityManager.unwrap(Session.class);
        TypedQuery<Score> theQuery = currentSession.createQuery("from Score where student_id=:s and quiz_id=:q", Score.class);
        theQuery.setParameter("s", student);
        theQuery.setParameter("q", quiz);
        try {
            return theQuery.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}

