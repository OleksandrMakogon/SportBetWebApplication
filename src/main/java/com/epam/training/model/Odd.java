package com.epam.training.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Odd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long odd_id;

    @ManyToOne
    private Outcome outcome;
    private LocalDate validFrom;
    private LocalDate validTo;
    private Double oddValue;

    public Odd(){};

    public Odd(Outcome outcome, LocalDate validFrom, LocalDate validTo, Double oddValue) {
        this.outcome = outcome;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.oddValue = oddValue;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }

    public Double getOddValue() {
        return oddValue;
    }

    public void setOddValue(Double oddValue) {
        this.oddValue = oddValue;
    }

    public Long getOdd_id() {
        return odd_id;
    }

    public void setOdd_id(Long odd_id) {
        this.odd_id = odd_id;
    }
}
