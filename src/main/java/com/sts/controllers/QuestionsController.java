package com.sts.controllers;


import com.sts.DTO.PlayerDTO;
import com.sts.DTO.QuestionsDTO;


import com.sts.services.Implementation.QuestionsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class QuestionsController {
    @Autowired
    private QuestionsServiceImpl questServiceImpl;
    @PostMapping(value="/add-questions")
    public ResponseEntity<QuestionsDTO> registerQuestions(@RequestBody QuestionsDTO questdto) {
        return new ResponseEntity<QuestionsDTO>(questServiceImpl.registerQuestions(questdto), HttpStatus.OK);
    }
    @GetMapping(value="/get-questionslist")
    public List<QuestionsDTO> getQuestionsList(){
        return questServiceImpl.getQuestionsList();
    }
    @GetMapping(value="/get-questions/{id}")
    public ResponseEntity<QuestionsDTO> getPlayerById(@PathVariable("id") Long id){
        return new ResponseEntity<QuestionsDTO>(questServiceImpl.getQuestionsById(id),HttpStatus.OK);
    }
    @PutMapping(value="/update-questions/{id}")
    public ResponseEntity<QuestionsDTO> updateTournament(@PathVariable("id")Long id , @RequestBody QuestionsDTO questdto){
        return new ResponseEntity<QuestionsDTO>(questServiceImpl.updateQuestions(questdto, id), HttpStatus.OK);
    }
    @DeleteMapping(value="/delete-questions/{id}")
    public ResponseEntity<Void> deleteQuestionsById(@PathVariable("id") Long id){
        questServiceImpl.deleteQuestionsById(id);
        return new  ResponseEntity<Void>(HttpStatus.OK);
    }


}
