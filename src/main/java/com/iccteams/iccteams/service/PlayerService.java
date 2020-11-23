package com.iccteams.iccteams.service;

import com.iccteams.iccteams.model.Player;

import java.util.List;

public interface PlayerService {
    public List<Player> findAll();

    public Player findById(int id);

    public void save(Player player);

    public void deleteById(int id);
}
