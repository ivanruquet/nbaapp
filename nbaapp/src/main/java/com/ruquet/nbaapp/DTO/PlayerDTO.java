package com.ruquet.nbaapp.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer jerseyNumber;
    private TeamDTO team;

    public PlayerDTO(String firstName, String lastName, Integer jerseyNumber) {

    }
}
