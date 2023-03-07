package com.proj.java.onlineexaminationsystem.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int question_id;
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz_id;
    @Column
    private String question;
    @Column
    private String option1;
    @Column
    private String option2;
    @Column
    private String option3;
    @Column
    private String option4;
    @Column
    private String correct_answer;
    @Column
    private int marks;
}
