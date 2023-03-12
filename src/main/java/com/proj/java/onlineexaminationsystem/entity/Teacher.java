package com.proj.java.onlineexaminationsystem.entity;

import jakarta.persistence.*;
import jakarta.websocket.ClientEndpoint;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher extends Person{
    @OneToMany(mappedBy="teacher_id",cascade = CascadeType.ALL)
    private List<Quiz> quizzes;
    @Column
    private String subject;

    public Teacher() {
    }
    public Teacher(List<Quiz> quizzes, String subject) {
        this.quizzes = quizzes;
        this.subject = subject;
    }
    public List<Quiz> getQuiz() {
        return quizzes;
    }

    public void setQuiz(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "quizzes=" + quizzes +
                ", subject='" + subject + '\'' +
                '}';
    }
}
