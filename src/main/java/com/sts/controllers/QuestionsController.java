package com.sts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sts.DTO.QuestionsDTO;
import com.sts.services.Implementation.QuestionsServiceImpl;

@RestController
@RequestMapping("/api/admin")
public class QuestionsController {
	@Autowired
	private QuestionsServiceImpl questServiceImpl;

	@PostMapping(value = "/add-questions")
	public ResponseEntity<QuestionsDTO> registerQuestions(@RequestBody QuestionsDTO questdto) {
		return new ResponseEntity<QuestionsDTO>(questServiceImpl.registerQuestions(questdto), HttpStatus.OK);
	}

	@GetMapping(value = "/get-questionslist")
	public List<QuestionsDTO> getQuestionsList() {
		return questServiceImpl.getQuestionsList();
	}

	@GetMapping(value = "/get-questions/{id}")
	public ResponseEntity<QuestionsDTO> getPlayerById(@PathVariable("id") Long id) {
		return new ResponseEntity<QuestionsDTO>(questServiceImpl.getQuestionsById(id), HttpStatus.OK);
	}

	@PutMapping(value = "/update-questions/{id}")
	public ResponseEntity<QuestionsDTO> updateQuestions(@PathVariable("id") Long id,
			@RequestBody QuestionsDTO questdto) {
		return new ResponseEntity<QuestionsDTO>(questServiceImpl.updateQuestions(questdto, id), HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete-questions/{id}")
	public ResponseEntity<Void> deleteQuestionsById(@PathVariable("id") Long id) {
		questServiceImpl.deleteQuestionsById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
