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
    private String batch;

    public Student() {
    }

    public Student(List<Score> scores, List<Result> results, String batch) {
        this.scores = scores;
        this.results = results;
        this.batch = batch;
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
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    @Override
    public String toString() {
        return "Student{" +
                "scores=" + scores +
                ", results=" + results +
                ", batch='" + batch + '\'' +
                '}';
    }
}
