package com.proj.java.onlineexaminationsystem.service;

import com.proj.java.onlineexaminationsystem.entity.Student;
import com.proj.java.onlineexaminationsystem.repository.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

	@Autowired
	private StudentDAO studentDAO;

	public Student getStudent(final int id) {
		return studentDAO.getStudent(id);
	}

	public List<Student> getStudents() {
		return studentDAO.getStudents();
	}

	public void addStudent(final Student student) {
		studentDAO.addStudent(student);
	}

	public void updateStudent(final Student student) {
		studentDAO.updateStudent(student);
	}

	public void deleteStudent(final int id) {
		studentDAO.deleteStudent(id);
	}

}