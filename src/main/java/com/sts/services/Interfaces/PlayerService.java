package com.sts.services.Interfaces;

import java.util.List;

import com.sts.DTO.PlayerDTO;


public interface PlayerService {

	public PlayerDTO registerPlayer(PlayerDTO playerdto);
	public List<PlayerDTO> getPlayerList();
	public PlayerDTO getPlayerById(long id);
	public PlayerDTO updatePlayer(PlayerDTO playerdto, long id);
	 public void deletePlayerById(long id);
}
