package com.proj.java.onlineexaminationsystem.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int quiz_id;

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

    public Quiz(int quiz_id, String quiz_title, String subject, String duration, int total_max_marks) {
        this.quiz_id = quiz_id;
        this.quiz_title = quiz_title;
        this.subject = subject;
        this.duration = duration;
        this.total_max_marks = total_max_marks;
        avg_score=0;
    }

    public Quiz() {

    }

    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
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
}
