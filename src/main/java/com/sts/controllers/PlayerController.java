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
import com.sts.DTO.PlayerDTO;
import com.sts.services.Implementation.PlayerServiceImpl;

@RestController
@RequestMapping("/api/admin")
public class PlayerController {
	@Autowired
	private PlayerServiceImpl playerServiceImpl;

	@PostMapping(value = "/add-player")
	public ResponseEntity<PlayerDTO> registerPlayer(@RequestBody PlayerDTO playerdto) {
		return new ResponseEntity<PlayerDTO>(playerServiceImpl.registerPlayer(playerdto), HttpStatus.OK);
	}

	@GetMapping(value = "/get-playerlist")
	public List<PlayerDTO> getPlayerList() {
		return playerServiceImpl.getPlayerList();
	}

	@GetMapping(value = "/get-player/{id}")
	public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable("id") Long id) {
		return new ResponseEntity<PlayerDTO>(playerServiceImpl.getPlayerById(id), HttpStatus.OK);
	}

	@PutMapping(value = "/update-player/{id}")
	public ResponseEntity<PlayerDTO> updatePlayer(@PathVariable("id") Long id, @RequestBody PlayerDTO playerdto) {
		return new ResponseEntity<PlayerDTO>(playerServiceImpl.updatePlayer(playerdto, id), HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete-player/{id}")
	public ResponseEntity<Void> deletePlayerById(@PathVariable("id") Long id) {
		playerServiceImpl.deletePlayerById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
