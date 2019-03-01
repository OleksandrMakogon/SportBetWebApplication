package com.epam.training.service;

import com.epam.training.model.Currency;
import com.epam.training.model.Player;
import com.epam.training.model.Wager;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface PlayerService {

    List<Player> getAll();

    List<Wager> getAllWagers();

    void addPlayer(Player player);

    Player getPlayer(String player_login, String password);

   default Map<String, String> getCurrencyMap(){
       Map<String, String> currency = new HashMap<>();
       for (Currency cur : Currency.values()) {
           currency.put(cur.toString(), cur.toString());
       }
       return currency;
    }

}
