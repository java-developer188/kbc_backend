package com.sts.services.Interfaces;

import java.util.List;

import com.sts.DTO.QuestionsDTO;

public interface QuestionsService {
	public QuestionsDTO registerQuestions(QuestionsDTO questiondto);

	public List<QuestionsDTO> getQuestionsList();

	public QuestionsDTO getQuestionsById(long id);

	public QuestionsDTO updateQuestions(QuestionsDTO questiondto, long id);

	public void deleteQuestionsById(long id);
}
