package com.proj.java.onlineexaminationsystem.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String name;
    @Column(unique = true)
    private String email;
    @Column
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_of_birth;
    @Column
    private String gender;
    @Column
    private String password;

    @OneToMany(mappedBy = "teacher_id", cascade = CascadeType.ALL)
    private List<Quiz> quiz;

    public Teacher() {
    }

    public Teacher(int id, String name, String email, Date date_of_birth, String gender) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Quiz> getQuiz() {
        return quiz;
    }

    public void setQuiz(List<Quiz> quiz) {
        this.quiz = quiz;
    }

    @Override
    public String toString() {
        return "Teacher [id=" + id + ", name=" + name + ", email=" + email + ", date_of_birth=" + date_of_birth
                + ", gender=" + gender;
    }

}
