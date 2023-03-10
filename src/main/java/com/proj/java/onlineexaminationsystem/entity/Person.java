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

    public Person() {
    }

    public Person(int person_id, String name, String email, Date date_of_birth, String gender) {
        this.person_id = person_id;
        this.name = name;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "person_id=" + person_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", gender='" + gender + '\'' +
                '}';
    }
}
