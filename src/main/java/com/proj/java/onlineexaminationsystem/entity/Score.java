package com.proj.java.onlineexaminationsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int score_id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question_id;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz_id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student_id;

    @Column
    private String score;
    @Column
    private String choosen_answer;

    public Score() {
    }

    public int getScore_id() {
        return score_id;
    }

    public void setScore_id(int score_id) {
        this.score_id = score_id;
    }

    public Question getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Question question_id) {
        this.question_id = question_id;
    }

    public Quiz getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(Quiz quiz_id) {
        this.quiz_id = quiz_id;
    }

    public Student getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Student student_id) {
        this.student_id = student_id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "score_id=" + score_id +
                ", question_id=" + question_id +
                ", quiz_id=" + quiz_id +
                ", student_id=" + student_id +
                ", score=" + score +
                '}';
    }

    public String getChoosen_answer() {
        return choosen_answer;
    }

    public void setChoosen_answer(String choosen_answer) {
        this.choosen_answer = choosen_answer;
    }
}
