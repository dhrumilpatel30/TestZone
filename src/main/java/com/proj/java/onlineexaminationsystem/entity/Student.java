package com.proj.java.onlineexaminationsystem.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
public class Student extends Person implements Serializable {
    @OneToMany(mappedBy="student_id",cascade = CascadeType.ALL)
    private List<Score> scores;
    @OneToMany(mappedBy="student_id",cascade = CascadeType.ALL)
    private List<Result> results;
    @Column
    private String Batch;
    @Column
    private int semester;
    @Column
    private int roll_no;

    public Student() {
    }
    @Override
    public String toString() {
        return "Student{" +
                "scores=" + scores +
                ", results=" + results +
                ", semester=" + semester +
                ", roll_no=" + roll_no +
                '}';
    }

    public Student(int person_id, String name, String email, Date date_of_birth, String gender, List<Score> scores, List<Result> results, String batch, int semester, int roll_no) {
        super(person_id, name, email, date_of_birth, gender);
        this.scores = scores;
        this.results = results;
        this.semester = semester;
        this.roll_no = roll_no;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getBatch() {
        return Batch;
    }

    public void setBatch(String batch) {
        Batch = batch;
    }
}
