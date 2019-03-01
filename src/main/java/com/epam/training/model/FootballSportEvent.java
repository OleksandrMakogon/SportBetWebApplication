package com.epam.training.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class FootballSportEvent extends SportEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long event_id;

    public FootballSportEvent(){};
    public FootballSportEvent(String title, LocalDate startDate, LocalDate endDate) {
        this.setEndDate(endDate);
        this.setStartDate(startDate);
        this.setTitle(title);
        setType();
    }

    @Override
    void setType() {
        type = "Football event";
    }

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }
}
