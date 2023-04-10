package com.proj.java.onlineexaminationsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int question_id;
    @ManyToOne(fetch = FetchType.EAGER)
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
    private int max_marks;


    public Question() {
    }

    public Question(int question_id, Quiz quiz_id, String question, String option1, String option2,
                    String option3, String option4, String correct_answer, int max_marks) {
        this.question_id = question_id;
        this.quiz_id = quiz_id;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correct_answer = correct_answer;
        this.max_marks = max_marks;

    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public Quiz getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(Quiz quiz_id) {
        this.quiz_id = quiz_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public int getMax_marks() {
        return max_marks;
    }

    public void setMax_marks(int max_marks) {
        this.max_marks = max_marks;
    }


    @Override
    public String toString() {
        return "Question{" +
                "question_id=" + question_id +
                ", quiz_id=" + quiz_id +
                ", question='" + question + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", correct_answer='" + correct_answer + '\'' +
                ", max_marks=" + max_marks +
                '}';
    }


}
