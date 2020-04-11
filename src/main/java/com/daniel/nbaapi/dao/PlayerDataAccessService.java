package com.daniel.nbaapi.dao;

import com.daniel.nbaapi.model.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("PlayerDataAccessService")
public class PlayerDataAccessService implements PlayerDAO{

    private static List<Player> DB = new ArrayList<>();

    @Override
    public int insertPlayer(UUID id, Player player) {
        DB.add(new Player(id, player.getName()));
        return 1;
    }

    @Override
    public List<Player> selectAllPlayers() {
        return DB;
    }

    @Override
    public Optional<Player> selectPlayerById(UUID id) {
        return DB.stream().filter(player -> player.getId().equals(id)).
                findFirst();
    }

    @Override
    public int deletePlayerById(UUID id) {
        Optional<Player> player = selectPlayerById(id);
        if (!player.isPresent()) {
            return 0;
        }
        DB.remove(player.get());
        return 1;
    }

    @Override
    public int updateplayerById(UUID id, Player playerUpdate) {
        return selectPlayerById(id)
                .map(player -> {
                    int indexToUpdate = DB.indexOf(player);
                    if (indexToUpdate >= 0){
                        DB.set(indexToUpdate, new Player(id, playerUpdate.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
