package com.proj.java.onlineexaminationsystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.java.onlineexaminationsystem.entity.Teacher;
import com.proj.java.onlineexaminationsystem.repository.TeacherDAO;

@Service
public class TeacherService {

	@Autowired
	private TeacherDAO teacherDAO;

	public Teacher getTeacher(final int id) {
		return teacherDAO.getTeacher(id);
	}

	public List<Teacher> getTeachers() {
		return teacherDAO.getTeachers();
	}

	public void addTeacher(final Teacher teacher) {
		teacherDAO.addTeacher(teacher);
	}

	public void updateTeacher(final Teacher teacher) {
		teacherDAO.updateTeacher(teacher);
	}

	public void deleteTeacher(final int id) {
		teacherDAO.deleteTeacher(id);
	}

}