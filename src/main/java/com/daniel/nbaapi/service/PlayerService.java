package com.daniel.nbaapi.service;

import com.daniel.nbaapi.dao.PlayerDAO;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.daniel.nbaapi.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerDAO playerDao;

    @Autowired
    public PlayerService(@Qualifier("PlayerDataAccessService") PlayerDAO playerDao) {
        this.playerDao = playerDao;
    }

    public int addPlayer(Player player){
        return playerDao.insertPlayer(player);
    }

    public List<Player> getAllPlayers(){
        return playerDao.selectAllPlayers();
    }

    public Optional<Player> getPlayerById(UUID id){
        return playerDao.selectPlayerById(id);
    }

    public int deletePlayerById(UUID id){
        return playerDao.deletePlayerById(id);
    }

    public int updatePlayer(UUID id, Player player){
        return playerDao.updateplayerById(id, player);
    }
}