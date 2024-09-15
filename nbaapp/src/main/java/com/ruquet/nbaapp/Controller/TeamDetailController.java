package com.ruquet.nbaapp.Controller;

import com.ruquet.nbaapp.DTO.TeamDetailDTO;
import com.ruquet.nbaapp.Service.TeamDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamDetailController {

    private TeamDetailService teamDetailService;

    @Autowired
    public TeamDetailController(TeamDetailService teamDetailService) {
        this.teamDetailService = teamDetailService;
    }

    @GetMapping("/showAll")
    public List<TeamDetailDTO> showAll() {
        return teamDetailService.getAllDetails();
    }

}
