package com.proj.java.onlineexaminationsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int score_id;
}
