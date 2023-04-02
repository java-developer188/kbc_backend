package com.sts.services.Interfaces;

import java.util.List;

import com.sts.DTO.OptionsDTO;

public interface OptionsService {
	public OptionsDTO AddOptions(OptionsDTO optiondto);

	public List<OptionsDTO> getOptionsList();

	public OptionsDTO getOptionsById(long id);

	public OptionsDTO updateOptions(OptionsDTO optiondto, long id);

	public void deleteOptionsById(long id);
}
