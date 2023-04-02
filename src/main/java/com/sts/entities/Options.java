package com.sts.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "options")
public class Options {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String AnswerOptions;
	@Column
	private boolean correctAns;
	@Column
	private boolean fiftyfifty;
	@Column
	private Integer publicOpinion;
	@Column
	private boolean PhnOfFrend;

	@ManyToOne
	@JoinColumn(name = "question_id", nullable = false)
	private Questions question;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAnswerOptions() {
		return AnswerOptions;
	}

	public void setAnswerOptions(String answerOptions) {
		AnswerOptions = answerOptions;
	}

	public boolean isCorrectAns() {
		return correctAns;
	}

	public void setCorrectAns(boolean correctAns) {
		this.correctAns = correctAns;
	}

	public boolean isFiftyfifty() {
		return fiftyfifty;
	}

	public void setFiftyfifty(boolean fiftyfifty) {
		this.fiftyfifty = fiftyfifty;
	}

	public Integer getPublicOpinion() {
		return publicOpinion;
	}

	public void setPublicOpinion(Integer publicOpinion) {
		this.publicOpinion = publicOpinion;
	}

	public boolean isPhnOfFrend() {
		return PhnOfFrend;
	}

	public void setPhnOfFrend(boolean phnOfFrend) {
		PhnOfFrend = phnOfFrend;
	}

}
