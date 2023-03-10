package com.proj.java.onlineexaminationsystem.entity;

import jakarta.persistence.*;
import jakarta.websocket.ClientEndpoint;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher extends Person{
    @OneToMany(mappedBy="teacher_id",cascade = CascadeType.ALL)
    private List<Quiz> quiz;
    @Column
    private String subject;

    public Teacher() {
    }
    public Teacher(List<Quiz> quiz, String subject) {
        this.quiz = quiz;
        this.subject = subject;
    }
    public List<Quiz> getQuiz() {
        return quiz;
    }

    public void setQuiz(List<Quiz> quiz) {
        this.quiz = quiz;
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
                "quiz=" + quiz +
                ", subject='" + subject + '\'' +
                '}';
    }
}
