package com.ruquet.nbaapp.Service;

import com.ruquet.nbaapp.DTO.TeamDetailDTO;
import com.ruquet.nbaapp.Model.Player;

import java.util.List;

public interface ITeamDetailService {

    public List<TeamDetailDTO> getAllDetails();

}
