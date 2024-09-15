package com.ruquet.nbaapp.Service;

import com.ruquet.nbaapp.DTO.PlayerDTO;
import com.ruquet.nbaapp.DTO.TeamDetailDTO;
import com.ruquet.nbaapp.Model.Player;
import com.ruquet.nbaapp.Model.Team;
import com.ruquet.nbaapp.Repository.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamDetailService implements ITeamDetailService {

    private ITeamRepository teamRepository;
    private TeamService teamService;
    private PlayerService playerService;

    @Autowired
    public TeamDetailService(PlayerService playerService, ITeamRepository teamRepository, TeamService teamService) {
        this.playerService = playerService;
        this.teamRepository = teamRepository;
        this.teamService = teamService;
    }

    @Override
    public List<TeamDetailDTO> getAllDetails() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream().map(team -> {
            // Team Null?
            if (team == null) {
                throw new IllegalStateException("Team cannot be null");
            }

            // Id or Name null?
            if (team.getId() == null || team.getName() == null) {
                throw new IllegalStateException("Team ID or Name cannot be null");
            }

            List<Player> players = Optional.ofNullable(team.getPlayers()).orElse(Collections.emptyList());
            List<PlayerDTO> playerDTOs = players.stream().map(player -> {
                // Player null?
                if (player == null) {
                    throw new IllegalStateException("Player cannot be null");
                }
                PlayerDTO playerDTO = playerService.playerToDTO(player);

                // Player team null?
                if (player.getTeam() == null) {
                    playerDTO.setTeam(null);
                } else {
                    playerDTO.setTeam(teamService.teamToTeamDTO(player.getTeam()));
                }
                return playerDTO;
            }).collect(Collectors.toList());

            return new TeamDetailDTO(team.getId(), team.getName(), playerDTOs);
        }).collect(Collectors.toList());
    }


}
