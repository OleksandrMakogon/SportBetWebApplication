package com.epam.training.service;

import com.epam.training.model.*;

import java.util.List;
import java.util.Random;

public interface BetService {

    void calculateBalance(List<Wager> wagers, List<Result> results);
    Wager createWager(Player player, Double amount, Odd odd);
    List<Bet> createData();
    List<Result> getResults(List<Bet> bets);
    void printBets(List<Bet> bets);
    void setRandom(Random random);

}

