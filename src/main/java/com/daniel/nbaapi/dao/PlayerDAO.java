package com.daniel.nbaapi.dao;

import com.daniel.nbaapi.model.Player;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlayerDAO {

    int insertPlayer(UUID id, Player player);
    default int insertPlayer(Player player){
        UUID id = UUID.randomUUID();
        return insertPlayer(id, player);
    }

    List<Player> selectAllPlayers();

    Optional<Player> selectPlayerById(UUID id);

    int deletePlayerById(UUID id);

    int updateplayerById(UUID id, Player player);
}
