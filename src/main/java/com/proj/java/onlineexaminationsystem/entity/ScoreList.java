package com.proj.java.onlineexaminationsystem.entity;

import java.util.ArrayList;
import java.util.List;

public class ScoreList {
    List<Score> scores = new ArrayList<>();
    int length;

    public ScoreList(List<Score> scores) {
        this.scores = scores;
        length = scores.size();
    }

    public ScoreList() {
    }

    public ScoreList(List<Score> scores, int length) {
        this.scores = scores;
        this.length = length;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
