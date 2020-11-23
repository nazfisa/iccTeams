package com.iccteams.iccteams.service.Impl;

import com.iccteams.iccteams.model.Player;
import com.iccteams.iccteams.repository.PlayerRepository;
import com.iccteams.iccteams.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerRepositoryImpl implements PlayerService {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    @Autowired
    private PlayerRepository playerRepository;
    @Override
    public List<Player> findAll() {
        return playerRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Player findById(int id) {
        Optional<Player> result = playerRepository.findById(id);
        Player player = null;
        if(result.isPresent()){
            player = result.get();
        }
        return player;
    }

    @Override
    public void save(Player player) {
        //player.setDOB(LocalDate.parse(player.getDOB(), formatter));
        playerRepository.save(player);
    }

    @Override
    public void deleteById(int id) {

        playerRepository.deleteById(id);
    }
}
