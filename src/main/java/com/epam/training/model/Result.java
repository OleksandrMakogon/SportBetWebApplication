package com.epam.training.model;

import javax.persistence.*;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long result_id;

    @OneToOne
    private Outcome outcome;
    private String description;

    public Result(){};
    public Result(Outcome outcome, SportEvent event, String description) {
        this.outcome = outcome;
        this.description = description;
    }

    public Long getResult_id() {
        return result_id;
    }

    public void setResult_id(Long result_id) {
        this.result_id = result_id;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
