package com.epam.training.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Wager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wager_id;

    @ManyToOne
    private Player player;

    @ManyToOne
    private Odd odd;
    private Double amount;
    private Currency currency;
    private LocalDate timestamp;
    private Boolean isProcessed;
    private Boolean isWin;

    public Wager(Player player, Odd odd, Double amount) {
        this.player = player;
        this.odd = odd;
        this.amount = amount;
        this.currency = player.getCurrency();
        this.isProcessed = false;
    }

    public Wager(){};

    @Override
    public String toString() {
        return "Wager for '" + odd.getOutcome().getBet().getSportEvent().getTitle() + "'. " + odd.getOutcome().getBet().getDescription() +
                " will be " + odd.getOutcome().getValue() + ". Amount: " + amount + " " + currency + ". Odd is " + odd.getOddValue() + ". Player: " + player.getPlayer_name();
    }

    public Long getWager_id() {
        return wager_id;
    }

    public void setWager_id(Long wager_id) {
        this.wager_id = wager_id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Odd getOdd() {
        return odd;
    }

    public void setOdd(Odd odd) {
        this.odd = odd;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getProcessed() {
        return isProcessed;
    }

    public void setProcessed(Boolean processed) {
        isProcessed = processed;
    }

    public Boolean getWin() {
        return isWin;
    }

    public void setWin(Boolean win) {
        isWin = win;
    }
}
