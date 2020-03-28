package com.daniel.nbaapi.dao;

import com.daniel.nbaapi.model.Player;
import java.util.UUID;

public interface PlayerDAO {

    int insertPlayer(UUID id, Player player);
    default int addPlayer(Player player){
        UUID id = UUID.randomUUID();
        return insertPlayer(id, player);
    }
}
