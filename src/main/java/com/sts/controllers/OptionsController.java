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

import com.sts.DTO.OptionsDTO;
import com.sts.services.Implementation.OptionsServiceImpl;

@RestController
@RequestMapping("/api/admin")
public class OptionsController {
	@Autowired
	private OptionsServiceImpl optionServiceImpl;

	@PostMapping(value = "/add-options")
	public ResponseEntity<OptionsDTO> AddOptions(@RequestBody OptionsDTO optiondto) {
		return new ResponseEntity<OptionsDTO>(optionServiceImpl.AddOptions(optiondto), HttpStatus.OK);
	}

	@GetMapping(value = "/get-optionslist")
	public List<OptionsDTO> getOptionsList() {
		return optionServiceImpl.getOptionsList();
	}

	@GetMapping(value = "/get-options/{id}")
	public ResponseEntity<OptionsDTO> getOptionsById(@PathVariable("id") Long id) {
		return new ResponseEntity<OptionsDTO>(optionServiceImpl.getOptionsById(id), HttpStatus.OK);
	}

	@PutMapping(value = "/update-options/{id}")
	public ResponseEntity<OptionsDTO> updateOptions(@PathVariable("id") Long id, @RequestBody OptionsDTO optiondto) {
		return new ResponseEntity<OptionsDTO>(optionServiceImpl.updateOptions(optiondto, id), HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete-options/{id}")
	public ResponseEntity<Void> deleteOptionsById(@PathVariable("id") Long id) {
		optionServiceImpl.deleteOptionsById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
