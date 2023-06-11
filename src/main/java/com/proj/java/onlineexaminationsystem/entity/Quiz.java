package com.proj.java.onlineexaminationsystem.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int quiz_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher_id;
    @OneToMany(mappedBy = "quiz_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Question> questions;
    @OneToMany(mappedBy = "quiz_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Score> scores;
    @OneToMany(mappedBy = "quiz_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Result> results;
    @Column
    private String quiz_title;
    @Column
    private String subject;
    @Column
    private String duration;
    @Column
    private int total_max_marks;
    @Column
    private int avg_score;
    @Column
    private int passing_marks;
    @Column
    private boolean ispublished;

    public Quiz() {
    }

    public Quiz(int quiz_id, String quiz_title, String subject, String duration, int total_max_marks, int avg_score) {
        this.quiz_id = quiz_id;
        this.quiz_title = quiz_title;
        this.subject = subject;
        this.duration = duration;
        this.total_max_marks = total_max_marks;
        this.avg_score = avg_score;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "quiz_id=" + quiz_id +
                ", quiz_title='" + quiz_title + '\'' +
                ", subject='" + subject + '\'' +
                ", duration='" + duration + '\'' +
                ", total_max_marks=" + total_max_marks +
                ", avg_score=" + avg_score +
                '}';
    }

    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public Teacher getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Teacher teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getQuiz_title() {
        return quiz_title;
    }

    public void setQuiz_title(String quiz_title) {
        this.quiz_title = quiz_title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getTotal_max_marks() {
        return total_max_marks;
    }

    public void setTotal_max_marks(int total_max_marks) {
        this.total_max_marks = total_max_marks;
    }

    public int getAvg_score() {
        return avg_score;
    }

    public void setAvg_score(int avg_score) {
        this.avg_score = avg_score;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getPassing_marks() {
        return passing_marks;
    }

    public void setPassing_marks(int passing_marks) {
        this.passing_marks = passing_marks;
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

    public boolean isIspublished() {
        return ispublished;
    }

    public void setIspublished(boolean ispublished) {
        this.ispublished = ispublished;
    }
}
