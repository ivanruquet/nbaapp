package com.ruquet.nbaapp.Service;

import com.ruquet.nbaapp.DTO.TeamDTO;
import com.ruquet.nbaapp.Model.Team;

import java.util.List;

public interface ITeamService {

    public List<TeamDTO> getAllTeams();

    public void addTeam(Team team);

    public void deleteTeam(Integer id);

    void editTeam(Integer id, Team team);
    public TeamDTO getTeamById(Integer id);
}
