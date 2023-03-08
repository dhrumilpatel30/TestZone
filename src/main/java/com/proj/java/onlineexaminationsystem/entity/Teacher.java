package com.proj.java.onlineexaminationsystem.entity;

import jakarta.persistence.*;
import jakarta.websocket.ClientEndpoint;

import java.util.Date;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int teacher_id;
    @Column
    private String subject;

    @Column
    private String name;

    @Column
    private String email;
    @Column
    private Date date_of_birth;

    public Teacher() {
    }

    public Teacher(int teacher_id, String subject, String name, String email, Date date_of_birth) {
        this.teacher_id = teacher_id;
        this.subject = subject;
        this.name = name;
        this.email = email;
        this.date_of_birth = date_of_birth;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacher_id=" + teacher_id +
                ", subject='" + subject + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", date_of_birth=" + date_of_birth +
                '}';
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
}
