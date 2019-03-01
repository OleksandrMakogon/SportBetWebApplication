package com.epam.training.model;

import java.time.LocalDate;

public abstract class SportEvent {

    abstract void setType();
    protected String type;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;

    public String getType() {
        return this.type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}