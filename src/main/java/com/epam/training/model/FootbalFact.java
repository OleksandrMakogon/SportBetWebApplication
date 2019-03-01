package com.epam.training.model;

import java.time.LocalDate;

public class FootbalFact extends EventFactory {
    @Override
    public FootballSportEvent createEvent(String title, LocalDate startDate, LocalDate endDate) {//NOPMD
        FootballSportEvent event = new FootballSportEvent(title, startDate, endDate);
        event.setType();
        return event;
    }
}
