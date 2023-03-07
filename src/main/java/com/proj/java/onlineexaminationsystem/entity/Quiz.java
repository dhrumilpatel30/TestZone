package com.proj.java.onlineexaminationsystem.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int quiz_id;


}
