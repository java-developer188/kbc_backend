package com.sts.services.Implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.DTO.PlayerDTO;
import com.sts.entities.Player;
import com.sts.repositories.PlayerRepository;
import com.sts.services.Interfaces.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {
	@Autowired
	private PlayerRepository playerRepo;
	@Autowired
	private ModelMapper modelmapper;

	@Override
	public PlayerDTO registerPlayer(PlayerDTO playerdto) {
		Player player = modelmapper.map(playerdto, Player.class); /// DTO to DAO
		Player savedplayer = playerRepo.save(player);
		PlayerDTO savedPlayerDto = modelmapper.map(savedplayer, PlayerDTO.class);  /// DAO to DTO
		return savedPlayerDto;
	}

	@Override
	public List<PlayerDTO> getPlayerList() {
		List<Player> players= playerRepo.findAll();
		 return players.stream().map((player) -> modelmapper.map(player, PlayerDTO.class)).collect(Collectors.toList());
	}

	@Override
	public PlayerDTO getPlayerById(long id) {
		 Player player = playerRepo.findById(id).get();
	        return modelmapper.map(player, PlayerDTO.class);
	}

	@Override
	public PlayerDTO updatePlayer(PlayerDTO playerdto, long id) {
		Player player = playerRepo.findById(id).orElseThrow(()->new RuntimeException("No such id exists"));
		PlayerDTO updatePlayerDto = modelmapper.map(player, PlayerDTO.class);  
		player.setAge(playerdto.getAge());
		player.setGender(playerdto.getGender());
		player.setName(playerdto.getName());
		playerRepo.save(player);
		return updatePlayerDto;
	}

	@Override
	public void deletePlayerById(long id) {
			 playerRepo.deleteById(id);
		}

			
	}

	


