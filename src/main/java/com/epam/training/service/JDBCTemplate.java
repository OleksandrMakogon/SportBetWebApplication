package com.epam.training.service;

import com.epam.training.model.Player;
import com.epam.training.model.Wager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class JDBCTemplate implements PlayerService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Wager> getAllWagers(){
        return null;
    }

    @Override
    public List<Player> getAll() {
        return jdbcTemplate.query(
                "select * from player",
                new BeanPropertyRowMapper<>(Player.class));
    }

    public Player getPlayer(String player_login, String password){
        return jdbcTemplate.query(
                "select * from player where player_login = ? and password = ?",
                new Object[] {player_login, password},
                new BeanPropertyRowMapper<>(Player.class)).stream().findAny().orElse(null);
    }

    @Transactional
    public void addPlayer(Player player){
        jdbcTemplate.update(
                "INSERT into player(player_login, player_name, account, currency, password, balance) values(?, ?, ?, ?, ?, ?)",
                player.getPlayer_login(), player.getPlayer_name(),
                player.getAccount(), player.getCurrency().toString(), player.getPassword(), player.getBalance());
    }
}
