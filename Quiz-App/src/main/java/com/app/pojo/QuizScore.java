package com.app.pojo;

import javax.persistence.*;

@Entity
@Table(name = "quiz_score")
public class QuizScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scoreId;

    private int score;
    private String email;
    private int quizID;
	public int getScoreId() {
		return scoreId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getQuizID() {
		return quizID;
	}

	public void setQuizID(int quizID) {
		this.quizID = quizID;
	}

	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}


	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

   
}
