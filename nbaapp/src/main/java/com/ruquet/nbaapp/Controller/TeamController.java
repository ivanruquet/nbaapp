package com.ruquet.nbaapp.Controller;

import com.ruquet.nbaapp.DTO.TeamDTO;
import com.ruquet.nbaapp.Model.Team;
import com.ruquet.nbaapp.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    private TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/teams")
    public List<TeamDTO> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/teams/{id}")
    public TeamDTO getTeamById(@PathVariable int id) {
        return teamService.getTeamById(id);
    }

    @PostMapping("/teams")
    public void createTeam(@RequestBody Team team) {
        teamService.addTeam(team);
    }

    @DeleteMapping("/teams/{id}")
    public void deleteTeam(@PathVariable int id) {
        teamService.deleteTeam(id);
    }

    @PutMapping("/teams/{id}")
    public void updateTeam(@PathVariable int id, @RequestBody Team team) {
        teamService.editTeam(id, team);
    }

}
