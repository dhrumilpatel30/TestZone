package com.proj.java.onlineexaminationsystem.service;

import com.proj.java.onlineexaminationsystem.entity.Quiz;
import com.proj.java.onlineexaminationsystem.entity.Student;
import com.proj.java.onlineexaminationsystem.repository.QuizDAO;
import com.proj.java.onlineexaminationsystem.repository.ResultDAO;
import com.proj.java.onlineexaminationsystem.repository.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;
    @Autowired
    private QuizDAO quizDAO;
    @Autowired
    private ResultDAO resultDAO;

    public Student getStudent(final int id) {
        return studentDAO.getStudent(id);
    }

    public Student getStudentByEmail(final String email) {
        return studentDAO.getStudentByEmail(email);
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

    public boolean login(String email, String password) {
        return studentDAO.validate(email, password);
    }

    public List<Quiz> getCompletedQuizzes(final Student student) {
        List<Quiz> quizzes = new ArrayList<>();
        for (Quiz q : quizDAO.getQuizs()) {
            if (resultDAO.isResultPresent(student, q)) {
                quizzes.add(q);
            }
        }
        return quizzes;
    }

    public List<Quiz> getPendingQuizzes(final Student student) {
        List<Quiz> quizzes = new ArrayList<>();
        for (Quiz q : quizDAO.getQuizs()) {
            if (!resultDAO.isResultPresent(student, q) && q.isIspublished()) {
                quizzes.add(q);
            }
        }
        return quizzes;
    }

}