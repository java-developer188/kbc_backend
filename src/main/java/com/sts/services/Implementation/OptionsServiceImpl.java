package com.sts.services.Implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.DTO.OptionsDTO;
import com.sts.entities.Options;
import com.sts.repositories.OptionsRepository;
import com.sts.services.Interfaces.OptionsService;

@Service
public class OptionsServiceImpl implements OptionsService {
	@Autowired
	private OptionsRepository optionRepo;
	@Autowired
	private ModelMapper modelmapper;

	@Override
	public OptionsDTO AddOptions(OptionsDTO optiondto) {
		Options option = modelmapper.map(optiondto, Options.class); /// DTO to DAO
		Options savedOption = optionRepo.save(option);
		OptionsDTO savedOptionDto = modelmapper.map(savedOption, OptionsDTO.class); /// DAO to DTO
		return savedOptionDto;
	}

	@Override
	public List<OptionsDTO> getOptionsList() {
		List<Options> options = optionRepo.findAll();
		return options.stream().map((option) -> modelmapper.map(option, OptionsDTO.class)).collect(Collectors.toList());
	}

	@Override
	public OptionsDTO getOptionsById(long id) {
		Options option = optionRepo.findById(id).get();
		return modelmapper.map(option, OptionsDTO.class);
	}

	@Override
	public OptionsDTO updateOptions(OptionsDTO optiondto, long id) {
		Options option = optionRepo.findById(id).orElseThrow(() -> new RuntimeException("No such id exists"));
		OptionsDTO updateOptionDto = modelmapper.map(option, OptionsDTO.class);
		option.setValue(optiondto.getValue());
		option.setCorrectAns(true);
		option.setFiftyfifty(true);
		option.setPhnOfFrend(true);
		option.setPublicOpinion(optiondto.getPublicOpinion());
		return updateOptionDto;
	}

	@Override
	public void deleteOptionsById(long id) {
		optionRepo.deleteById(id);

	}

	@Override
	public OptionsDTO getcorrectAnsByValue(long id) {
		Options option = optionRepo.findById(id).get();
		return modelmapper.map(option, OptionsDTO.class);
	}

	@Override
	public OptionsDTO getphnOfFrend(long id) {
		Options option = optionRepo.findById(id).get();
		return modelmapper.map(option, OptionsDTO.class);
	}

	@Override
	public OptionsDTO getfiftyfifty(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OptionsDTO getpublicOpinion(long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
