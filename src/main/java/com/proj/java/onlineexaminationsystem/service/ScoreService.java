package com.proj.java.onlineexaminationsystem.service;

import com.proj.java.onlineexaminationsystem.entity.Score;
import com.proj.java.onlineexaminationsystem.repository.ScoreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

	@Autowired
	private ScoreDAO scoreDAO;

	public Score getScore(final int id) {
		return scoreDAO.getScore(id);
	}

	public List<Score> getScores() {
		return scoreDAO.getScores();
	}

	public void addScore(final Score score) {
		scoreDAO.addScore(score);
	}

	public void updateScore(final Score score) {
		scoreDAO.updateScore(score);
	}

	public void deleteScore(final int id) {
		scoreDAO.deleteScore(id);
	}

}