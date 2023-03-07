package com.proj.java.onlineexaminationsystem.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int student_id;
    @Column
    private String email;
    @Column
    private String name;
    @Column
    private String batch;
    @Column
    private Date date_of_birth;
    @Column
    private String gender;

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", batch='" + batch + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", gender='" + gender + '\'' +
                '}';
    }

    public Student() {
    }

    public Student(int student_id, String email, String name, String batch, Date date_of_birth, String gender) {
        this.student_id = student_id;
        this.email = email;
        this.name = name;
        this.batch = batch;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
    }

}
