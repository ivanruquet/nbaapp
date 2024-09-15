package com.ruquet.nbaapp.Service;

import com.ruquet.nbaapp.DTO.PlayerDTO;
import com.ruquet.nbaapp.Model.Player;
import com.ruquet.nbaapp.Repository.IPlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PlayerService implements IPlayerService {

    private IPlayerRepository playerRepository;
    private TeamService teamService;

    public PlayerService(IPlayerRepository playerRepository, TeamService teamService) {
        this.playerRepository = playerRepository;
        this.teamService = teamService;
    }

    @Override
    public List<PlayerDTO> getAllPlayers() {
        List<Player> allPlayers = playerRepository.findAll();
        Stream<PlayerDTO> playerDTOStream = allPlayers.stream().map(player -> playerToDTO(player));
        List<PlayerDTO> allPlayerDTO = playerDTOStream.collect(Collectors.toList());
        return allPlayerDTO;
    }

    @Override
    public void savePlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void editPlayer(Integer id, Player player) {
        Optional<Player> player2 = playerRepository.findById(id);
        if (player2.isPresent()) {
            Player newPlayer = player2.get();

            if (player.getFirstName() != null) {
                newPlayer.setFirstName(player.getFirstName());
            }

            if (player.getLastName() != null) {
                newPlayer.setLastName(player.getLastName());
            }

            if (player.getJerseyNumber() != null) {
                newPlayer.setJerseyNumber(player.getJerseyNumber());
            }

            playerRepository.save(newPlayer);
        } else throw new EntityNotFoundException("Player not found with id: " + id);
    }

    @Override
    public void deletePlayer(Integer id) {
        playerRepository.deleteById(id);
    }

    @Override
    public Player getPlayerById(Integer id) {
        return playerRepository.findById(id).orElseThrow(() -> new RuntimeException("Player not found with id: " + id));
    }

    public PlayerDTO playerToDTO(Player player) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(player.getId());
        playerDTO.setFirstName(player.getFirstName());
        playerDTO.setLastName(player.getLastName());
        playerDTO.setJerseyNumber(player.getJerseyNumber());

        if (player.getTeam() != null) {
            playerDTO.setTeam(teamService.teamToTeamDTO(player.getTeam()));
        } else {
            playerDTO.setTeam(null);
        }
        return playerDTO;
    }

}
