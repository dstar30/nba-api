package com.daniel.nbaapi.api;

import com.daniel.nbaapi.model.Player;
import com.daniel.nbaapi.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/player")
@RestController
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @PostMapping
    public void addPlayer(@Valid @NotNull @RequestBody Player player){
        playerService.addPlayer(player);
    }

    @GetMapping
    public List<Player> getAllPlayers(){
        return playerService.getAllPlayers();
    }

    @GetMapping(path = "{id}")
    public Player getPlayerById(@PathVariable("id") UUID id){
        return playerService.getPlayerById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePlayerById(@PathVariable("id") UUID id){
        playerService.deletePlayerById(id);
    }

    @PutMapping(path = "{id}")
    public void updatePlayerById(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Player player){
        playerService.updatePlayer(id, player);
    }
}
