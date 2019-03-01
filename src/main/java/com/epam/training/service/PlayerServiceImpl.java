package com.epam.training.service;

import com.epam.training.model.Player;
import com.epam.training.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service
@Transactional(readOnly = true)
public class PlayerServiceImpl {

    @Autowired
    private PlayerRepository playerRepository;

    //@Override
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    //@Override
    public void addPlayer(Player player) {
        playerRepository.save(player);
    }

    //@Override
    @Transactional
    public Player getPlayer(String player_login, String password) {
        return new Player();
    }

}
