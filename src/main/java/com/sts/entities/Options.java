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
	private String Value;
	@Column
	private Boolean correctAns;
	@Column
	private Boolean fiftyfifty;
	@Column
	private Integer publicOpinion;
	@Column
	private Boolean PhnOfFrend;

	@ManyToOne
	@JoinColumn(name = "question_id", nullable = false)
	private Questions question;

	
	public Boolean getCorrectAns() {
		return correctAns;
	}

	public void setCorrectAns(Boolean correctAns) {
		this.correctAns = correctAns;
	}

	public Boolean getFiftyfifty() {
		return fiftyfifty;
	}

	public void setFiftyfifty(Boolean fiftyfifty) {
		this.fiftyfifty = fiftyfifty;
	}

	public Boolean getPhnOfFrend() {
		return PhnOfFrend;
	}

	public void setPhnOfFrend(Boolean phnOfFrend) {
		PhnOfFrend = phnOfFrend;
	}

	public Questions getQuestion() {
		return question;
	}

	public void setQuestion(Questions question) {
		this.question = question;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}

	public Integer getPublicOpinion() {
		return publicOpinion;
	}

	public void setPublicOpinion(Integer publicOpinion) {
		this.publicOpinion = publicOpinion;
	}


}
