package com.ruquet.nbaapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "player")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "jersey_number")
    private Integer jerseyNumber;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "team_id")
    @JsonIgnore
    private Team team;

    public Player(Integer id, String firstName, String lastName, Integer jerseyNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jerseyNumber = jerseyNumber;
    }
}
