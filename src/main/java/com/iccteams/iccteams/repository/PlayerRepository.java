package com.iccteams.iccteams.repository;

import com.iccteams.iccteams.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player,Integer> {
    public List<Player> findAllByOrderByNameAsc();
}
