package com.epam.training.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bet_id;
    @ManyToOne
    private FootballSportEvent sportEvent;
    private String description;
    @OneToMany
    private List<Outcome> outcomes = new ArrayList<>();
    private BetType betType;

    public Bet(){};
    public Bet(FootballSportEvent sportEvent, BetType betType, String description) {//NOPMD
        this.sportEvent = sportEvent;
        this.description = description;
        this.betType = betType;
    }

    public Long getBet_id() {
        return bet_id;
    }

    public void setBet_id(Long bet_id) {
        this.bet_id = bet_id;
    }

    public SportEvent getSportEvent() {
        return sportEvent;
    }

    public void setSportEvent(FootballSportEvent sportEvent) {
        this.sportEvent = sportEvent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Outcome> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<Outcome> outcomes) {
        this.outcomes = outcomes;
    }

    public BetType getBetType() {
        return betType;
    }

    public void setBetType(BetType betType) {
        this.betType = betType;
    }
}
