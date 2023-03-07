package com.proj.java.onlineexaminationsystem.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int question_id;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz q1;


}
