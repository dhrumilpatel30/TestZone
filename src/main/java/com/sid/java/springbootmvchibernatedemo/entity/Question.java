package com.sid.java.springbootmvchibernatedemo.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int question_id;

    @Column
    private int quiz_id;

}
