package com.proj.java.onlineexaminationsystem.entity;

import jakarta.persistence.*;
import jakarta.websocket.ClientEndpoint;

import java.util.Date;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int teacher_id;
    @Column
    private String subject;

    @Column
    private String name;

    @Column
    private String email;
    @Column
    private Date date_of_birth;
}
