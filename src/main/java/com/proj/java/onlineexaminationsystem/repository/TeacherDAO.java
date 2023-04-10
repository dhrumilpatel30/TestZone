package com.proj.java.onlineexaminationsystem.repository;

import com.proj.java.onlineexaminationsystem.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TeacherDAO {

    private EntityManager entityManager;

    @Autowired
    public TeacherDAO(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    public Teacher getTeacher(final int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Teacher teacher = currentSession.get(Teacher.class, id);
        currentSession.close();
        return teacher;
    }

    public Teacher validate(String email, String password) {
        Session currentSession = entityManager.unwrap(Session.class);
        TypedQuery<Teacher> theQuery = currentSession.createQuery("from Teacher where email =:email and password =:pass", Teacher.class);
        theQuery.setParameter("email", email);
        theQuery.setParameter("pass", password);
        try {
            return theQuery.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Teacher> getTeachers() {
        Session currentSession = entityManager.unwrap(Session.class);

        TypedQuery<Teacher> theQuery = currentSession.createQuery("from Teacher", Teacher.class);
        List<Teacher> teachers = theQuery.getResultList();

        currentSession.close();
        return teachers;
    }

    @Transactional
    public void addTeacher(final Teacher teacher) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.persist(teacher);
        currentSession.close();
    }

    @Transactional
    public void updateTeacher(final Teacher teacher) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.merge(teacher);
        currentSession.close();
    }

    @Transactional
    public void deleteTeacher(final int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Teacher teacher = currentSession.get(Teacher.class, id);
        currentSession.remove(teacher);
        currentSession.close();

    }
}

