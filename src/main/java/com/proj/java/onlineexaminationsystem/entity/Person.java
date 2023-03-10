package com.proj.java.onlineexaminationsystem.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int person_id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private Date date_of_birth;
    @Column
    private String gender;
}
