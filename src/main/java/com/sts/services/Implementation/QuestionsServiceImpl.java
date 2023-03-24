package com.sts.services.Implementation;

import com.sts.DTO.PlayerDTO;
import com.sts.DTO.QuestionsDTO;
import com.sts.entities.Questions;
import com.sts.repositories.QuestionsRepository;
import com.sts.services.Interfaces.QuestionsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionsServiceImpl implements QuestionsService{
    @Autowired
    private QuestionsRepository questRepo;
    @Autowired
    private ModelMapper modelmapper;
    @Override
    public QuestionsDTO registerQuestions(QuestionsDTO questiondto) {
        Questions quest = modelmapper.map(questiondto, Questions.class); /// DTO to DAO
        Questions savedQuest = questRepo.save(quest);
        QuestionsDTO savedQuestDto = modelmapper.map(savedQuest, QuestionsDTO.class);  /// DAO to DTO
        return savedQuestDto;
    }

    @Override
    public List<QuestionsDTO> getQuestionsList() {
        List<Questions> quest= questRepo.findAll();
        return quest.stream().map((player) -> modelmapper.map(player, QuestionsDTO.class)).collect(Collectors.toList());
    }

    @Override
    public QuestionsDTO getQuestionsById(long id) {
        Questions quest = questRepo.findById(id).get();
        return modelmapper.map(quest, QuestionsDTO.class);
    }

    @Override
    public QuestionsDTO updateQuestions(QuestionsDTO questiondto, long id) {
        Questions quest = questRepo.findById(id).orElseThrow(()->new RuntimeException("No such id exists"));
        QuestionsDTO updateQuestDto = modelmapper.map(quest, QuestionsDTO.class);
        quest.setQuest(questiondto.getQuest());
        return updateQuestDto;
    }

    @Override
    public void deleteQuestionsById(long id) {
        questRepo.deleteById(id);
    }
}
