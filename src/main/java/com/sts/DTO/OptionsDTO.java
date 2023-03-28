package com.sts.DTO;

public class OptionsDTO {
	private long id;
	
	private String AnswerOptions;
	
	private boolean correctAns;
	
	private boolean fiftyfifty;
	
	private Integer publicOpinion;

	private boolean PhnOfFrend;

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
