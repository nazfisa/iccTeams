package com.iccteams.iccteams.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Country {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Country name must not be empty!")
    private String name;
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<Player> player;

    public Country() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }
}
