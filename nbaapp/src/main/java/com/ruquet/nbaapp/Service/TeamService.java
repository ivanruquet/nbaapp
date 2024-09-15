package com.ruquet.nbaapp.Service;

import com.ruquet.nbaapp.DTO.TeamDTO;
import com.ruquet.nbaapp.Model.Player;
import com.ruquet.nbaapp.Model.Team;
import com.ruquet.nbaapp.Repository.IPlayerRepository;
import com.ruquet.nbaapp.Repository.ITeamRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Collator;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TeamService implements ITeamService {

    private ITeamRepository teamRepository;
    private IPlayerRepository playerRepository;

    @Autowired
    public TeamService(ITeamRepository teamRepository, IPlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public List<TeamDTO> getAllTeams() {
        List<Team> allTeams = teamRepository.findAll();
        Stream<TeamDTO> teamDTOStream = allTeams.stream().map(team -> teamToTeamDTO(team));
        List<TeamDTO> listTeamDTO = teamDTOStream.collect(Collectors.toList());
        return listTeamDTO;
    }

    @Override
    public void addTeam(Team team) {
        teamRepository.save(team);
    }

    @Override
    public void deleteTeam(Integer id) {
        Optional<Team> optionalTeam = teamRepository.findById(id);
        if (optionalTeam.isPresent()) {
            Team team = optionalTeam.get();

            List<Player> players = team.getPlayers();
            for (Player player : players) {
                player.setTeam(null);
                playerRepository.save(player);
            }
            teamRepository.deleteById(id);
        }
        else {
            throw new EntityNotFoundException("Team not found");
        }
    }

    @Override
    public void editTeam(Integer id, Team team) {
        Optional<Team> team2 = teamRepository.findById(id);
        if (team2.isPresent()) {
            Team newTeam = team2.get();

            if (team.getName() != null) {
                newTeam.setName(team.getName());
            }

            if (team.getCity() != null) {
                newTeam.setCity(team.getCity());
            }
            teamRepository.save(newTeam);
        }
        else throw new EntityNotFoundException("Team with ID: " + id + " not found!");
    }

    @Override
    public TeamDTO getTeamById(Integer id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Team with ID: " + id + " not found!"));
        return teamToTeamDTO(team);
    }


    public TeamDTO teamToTeamDTO(Team team) {
        TeamDTO teamDTO = new TeamDTO();
        if (teamDTO != null){
            teamDTO.setId(team.getId());
            teamDTO.setName(team.getName());
            teamDTO.setCity(team.getCity());
        }
        else{
            throw new EntityNotFoundException("Team not found");
        }
        return teamDTO;
    }

}
