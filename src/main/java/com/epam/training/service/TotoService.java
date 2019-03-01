package com.epam.training.service;

import com.epam.training.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
//@Component
public class TotoService implements BetService{

    @PersistenceContext
    private EntityManager entityManager;

    private Random random;

    public static final Logger LOGGER =
            LoggerFactory.getLogger(TotoService.class);

    public void setRandom(Random random){
        this.random = random;
    }

    public List<Result> getResults(List<Bet> bets) {
        //Preconditions.checkNotNull(bets);
        //Generate results
        List<Result> results = new ArrayList<>();
        for (Bet bet : bets) {
            int pos = random.nextInt(bet.getOutcomes().size());
            //System.out.println("Index = " + pos);
            results.add(new Result(bet.getOutcomes().get(pos), bet.getSportEvent(), bet.getDescription()));
        }
        for (Result result : results) {
            LOGGER.debug("Result for '" + result.getOutcome().getValue() +
                    "' " + result.getOutcome().getBet().getSportEvent().getType() + ". " + result.getDescription() +
                    ": " + result.getOutcome().getValue());
        }
        return results;
    }

    /**Balance calculation.
     * @param wagers wagers
     * @param results res
     */
    public void calculateBalance(List<Wager> wagers, List<Result> results) {
        //Preconditions.checkNotNull(wagers);
        //Preconditions.checkNotNull(results);
        //size
        // System.out.println("****************Method name (my):");
        for (Wager wager : wagers) {
            for (Result result : results) {
                if (wager.getOdd().getOutcome().equals(result.getOutcome())) {
                    Double prize = wager.getOdd().getOddValue() * wager.getAmount();
                    LOGGER.debug("Wager has played. " + wager.toString() + ". Prize: " + prize + " " + wager.getCurrency());
                    wager.getPlayer().setBalance(wager.getPlayer().getBalance() + prize);
                    break;
                }
            }
        }
    }
    public Wager createWager(Player player, Double amount, Odd odd){
        player.setBalance(player.getBalance() - amount);
        return new Wager(player, odd, amount);
    }

    @Transactional
    public List<Bet> createData(){
        //Factory usage
        FootballSportEvent fManUtdChelsea = new FootbalFact().createEvent("ManUtd - Chelsea",
                LocalDate.of(2018, 10, 20),
                LocalDate.of(2018, 10, 21));

        //create Bets
        Bet winnerManUtdChelsea = new Bet(fManUtdChelsea, BetType.Winner, "Winner");
        Bet goalsManUtdChelsea = new Bet(fManUtdChelsea, BetType.Goals, "Goals");
        Bet scoreAzar = new Bet(fManUtdChelsea, BetType.Player_Score, "Eden Azar score");

        //create Outcomes and Odds for winner MU-Chelsea
        Outcome manUntWinner = new Outcome("ManUnt", winnerManUtdChelsea);
        Odd manUntWinnerOdd = new Odd(manUntWinner, LocalDate.now(), LocalDate.now(), 1.9);
        manUntWinner.getOdds().add(manUntWinnerOdd);
        Outcome chelseaWinner = new Outcome("Chelsea", winnerManUtdChelsea);
        Odd chelseaWinnerOdd = new Odd(chelseaWinner, LocalDate.now(), LocalDate.now(), 2.0);
        chelseaWinner.getOdds().add(chelseaWinnerOdd);
        Outcome draw = new Outcome("Draw", winnerManUtdChelsea);
        Odd drawOdd = new Odd(draw, LocalDate.now(), LocalDate.now(), 1.7);
        draw.getOdds().add(drawOdd);

        //create Outcomes and Odds for goals MU-Chelsea
        Outcome goals0 = new Outcome("1", goalsManUtdChelsea);
        Odd goals0Odd = new Odd(goals0, LocalDate.now(), LocalDate.now(), 2.0);
        goals0.getOdds().add(goals0Odd);
        Outcome goals1 = new Outcome("2", goalsManUtdChelsea);
        Odd goals1Odd = new Odd(goals1, LocalDate.now(), LocalDate.now(), 1.8);
        goals1.getOdds().add(goals1Odd);
        Outcome goals2More = new Outcome(">=3", goalsManUtdChelsea);
        Odd goals2MoreOdd = new Odd(goals2More, LocalDate.now(), LocalDate.now(), 1.9);
        goals2More.getOdds().add(goals2MoreOdd);

        //create Outcomes and Odds for Player scores
        Outcome scoresAzar1 = new Outcome("0", scoreAzar);
        Odd scoresAzar1Odd = new Odd(scoresAzar1, LocalDate.now(), LocalDate.now(), 3.0);
        scoresAzar1.getOdds().add(scoresAzar1Odd);
        Outcome scoresAzar2 = new Outcome("1", scoreAzar);
        Odd scoresAzar2Odd = new Odd(scoresAzar2, LocalDate.now(), LocalDate.now(), 4.0);
        scoresAzar2.getOdds().add(scoresAzar2Odd);

        //Fill bets with outcomes
        winnerManUtdChelsea.getOutcomes().add(manUntWinner);
        winnerManUtdChelsea.getOutcomes().add(chelseaWinner);
        winnerManUtdChelsea.getOutcomes().add(draw);
        goalsManUtdChelsea.getOutcomes().add(goals0);
        goalsManUtdChelsea.getOutcomes().add(goals1);
        goalsManUtdChelsea.getOutcomes().add(goals2More);
        scoreAzar.getOutcomes().add(scoresAzar1);
        scoreAzar.getOutcomes().add(scoresAzar2);

        //All bets
        List<Bet> bets = new ArrayList<>();
        Collections.addAll(bets, winnerManUtdChelsea, goalsManUtdChelsea, scoreAzar);

        entityManager.persist(fManUtdChelsea);
        entityManager.persist(winnerManUtdChelsea);
        entityManager.persist(goalsManUtdChelsea);
        entityManager.persist(manUntWinner);
        entityManager.persist(manUntWinnerOdd);
        entityManager.persist(chelseaWinner);
        entityManager.persist(chelseaWinnerOdd);
        entityManager.persist(draw);
        entityManager.persist(drawOdd);
        entityManager.persist(goals0);
        entityManager.persist(goals0Odd);
        entityManager.persist(goals1);
        entityManager.persist(goals1Odd);
        entityManager.persist(goals2More);
        entityManager.persist(goals2MoreOdd);

        return bets;
    }

    public void printBets(List<Bet> bets) {
        //Print Bets

        int count = 1;
        for (Bet bet : bets) {
            for (Outcome outcome : bet.getOutcomes()) {
                LOGGER.debug(count + ": Bet on " + bet.getSportEvent().getTitle() + "; " + bet.getDescription() + " will be "
                        + outcome.getValue() + ". The odd is: " + outcome.getOdds().get(0).getOddValue());
                count++;
            }
        }
        //throw new DataBaseException("DB Fail!!!");
    }
}



