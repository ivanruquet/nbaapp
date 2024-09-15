package com.ruquet.nbaapp.Service;

import com.ruquet.nbaapp.DTO.PlayerDTO;
import com.ruquet.nbaapp.Model.Player;

import java.util.List;

public interface IPlayerService {

    public List<PlayerDTO> getAllPlayers();

    public void savePlayer(Player player);

    public void editPlayer (Integer id, Player player);

    public void deletePlayer(Integer id);

    public Player getPlayerById(Integer id);

}
