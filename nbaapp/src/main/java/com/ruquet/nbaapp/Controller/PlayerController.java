package com.ruquet.nbaapp.Controller;

import com.ruquet.nbaapp.DTO.PlayerDTO;
import com.ruquet.nbaapp.Model.Player;
import com.ruquet.nbaapp.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public List<PlayerDTO> showPlayers(){
        return playerService.getAllPlayers();
    }

    @GetMapping("/players/{id}")
    public PlayerDTO showPlayer(@PathVariable int id){
        Player player = playerService.getPlayerById(id);
        PlayerDTO playerDTO = playerService.playerToDTO(player);
        return playerDTO;
    }

    @PostMapping("/players")
    public void createPlayer(@RequestBody Player player){
        playerService.savePlayer(player);
    }

    @DeleteMapping("/players/{id}")
    public void deletePlayer(@PathVariable int id){
        playerService.deletePlayer(id);
    }

    @PutMapping("/players/{id}")
    public void updatePlayer(@PathVariable int id, @RequestBody Player player){
        playerService.editPlayer(id,player);
    }
}
