package com.proj.java.onlineexaminationsystem.repository;

import java.util.List;

import com.proj.java.onlineexaminationsystem.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
//@Transactional
public class TeacherDao {

	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public TeacherDao(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	public Teacher getTeacher(final int id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		Teacher teacher = currentSession.get(Teacher.class, id);
		currentSession.close();
		return teacher;
	}

	public List<Teacher> getTeachers() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// create a query
		TypedQuery<Teacher> theQuery =
				currentSession.createQuery("from Teacher", Teacher.class);
		
		// execute query and get result list
		List<Teacher> teachers = theQuery.getResultList();

		currentSession.close();
		return teachers;
	}
	@Transactional
	public void addTeacher(final Teacher teacher) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.persist(teacher);
		currentSession.close();
	}

	@Transactional
	public void updateTeacher(final Teacher teacher) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.merge(teacher);
		currentSession.close();
	}

	@Transactional
	public void deleteTeacher(final int id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
//		TypedQuery<Teacher> theQuery =
//			currentSession.createQuery("delete from Teacher where id=:tid", Teacher.class);
//		theQuery.setParameter("tid", id);
//		theQuery.executeUpdate();
		
		Teacher teacher = currentSession.get(Teacher.class, id);
		currentSession.remove(teacher);
		currentSession.close();
				
	}

}
