package com.proj.java.onlineexaminationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.java.onlineexaminationsystem.entity.Teacher;
import com.proj.java.onlineexaminationsystem.repository.TeacherDao;

@Service
public class TeacherService {

	@Autowired
	private TeacherDao teacherDao;

	public Teacher getTeacher(final int id) {
		return teacherDao.getTeacher(id);
	}

	public List<Teacher> getTeachers() {
		return teacherDao.getTeachers();
	}

	public void addTeacher(final Teacher teacher) {
		teacherDao.addTeacher(teacher);
	}

	public void updateTeacher(final Teacher teacher) {
		teacherDao.updateTeacher(teacher);
	}

	public void deleteTeacher(final int id) {
		teacherDao.deleteTeacher(id);
	}

}
