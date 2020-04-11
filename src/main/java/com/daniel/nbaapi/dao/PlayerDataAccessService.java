package com.daniel.nbaapi.dao;

import com.daniel.nbaapi.model.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("PlayerDataAccessService")
public class PlayerDataAccessService implements PlayerDAO{

    private static List<Player> DB = new ArrayList<Player>();

    @Override
    public int insertPlayer(UUID id, Player player) {
        DB.add(new Player(id, player.getName()));
        return 1;
    }

    @Override
    public List<Player> selectAllPlayers() {
        return DB;
    }
}
