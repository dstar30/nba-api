package com.daniel.nbaapi.service;

import com.daniel.nbaapi.dao.PlayerDAO;
import java.util.List;
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
}