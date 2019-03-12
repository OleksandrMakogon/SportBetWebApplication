package com.epam.training.service;

import com.epam.training.model.Player;
import com.epam.training.model.Wager;
import com.epam.training.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//using Repository
@Service("RepositoryPlayerService")
@Transactional(readOnly = true)
public class RepositoryPlayerService implements PlayerService{

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    @Override
    public List<Wager> getAllWagers() {
        return null;
    }

    @Override
    public void addPlayer(Player player) {
        playerRepository.save(player);
    }

    @Transactional
    public Player getPlayer(String player_login, String password) {
        return playerRepository.findByPlayer_loginAndPassword(player_login, password);
    }

}
