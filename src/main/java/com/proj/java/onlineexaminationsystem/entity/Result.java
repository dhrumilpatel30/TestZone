package com.proj.java.onlineexaminationsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int result_id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student_id;

    @Column
    private int result;

    public Result() {
    }

    public Result(int result_id, Quiz quiz_id, Student student_id, int result) {
        this.result_id = result_id;
        this.quiz_id = quiz_id;
        this.student_id = student_id;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "result_id=" + result_id +
                ", quiz_id=" + quiz_id +
                ", student_id=" + student_id +
                ", result=" + result +
                '}';
    }

    public int getResult_id() {
        return result_id;
    }

    public void setResult_id(int result_id) {
        this.result_id = result_id;
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

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
