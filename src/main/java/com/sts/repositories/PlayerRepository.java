package com.sts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.entities.Player;

public interface PlayerRepository extends JpaRepository<Player,Long>{

}
