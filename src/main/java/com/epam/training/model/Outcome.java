package com.epam.training.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Outcome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long outcome_id;
    private String value;

    @ManyToOne
    private Bet bet;

    @OneToMany
    private List<Odd> odds = new ArrayList<>();

    public Outcome(){};

    public Outcome(String value, Bet bet) {
        this.value = value;
        this.bet = bet;
    }

    public Long getOutcome_id() {
        return outcome_id;
    }

    public void setOutcome_id(Long outcome_id) {
        this.outcome_id = outcome_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public List<Odd> getOdds() {
        return odds;
    }

    public void setOdds(List<Odd> odds) {
        this.odds = odds;
    }
}
