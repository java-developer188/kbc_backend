package com.sts.services.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.sts.DTO.OptionsDTO;

public interface OptionsService {
	public OptionsDTO AddOptions(OptionsDTO optiondto);

	public List<OptionsDTO> getOptionsList();

	public OptionsDTO getOptionsById(long id);

	public OptionsDTO updateOptions(OptionsDTO optiondto, long id);

	public void deleteOptionsById(long id);

	@Query("SELECT value  from options WHERE options.correct_ans=1 AND question_id=?;")
	public OptionsDTO getcorrectAnsByValue(long id);

	@Query("SELECT value  from options WHERE phn_of_frend=1AND question_id=?;")
	public OptionsDTO getphnOfFrend(long id);

	@Query("")
	public OptionsDTO getfiftyfifty(long id);

	@Query("")
	public OptionsDTO getpublicOpinion(long id);

}
