package com.ruquet.nbaapp.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Team")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;


    @OneToMany(mappedBy = "team", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Player> players;

    public Team(String name, String city) {
        this.name = name;
        this.city = city;
    }

}
