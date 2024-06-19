package com.calendar;

import lombok.Data;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

@Data
public class Calendrier {
    private Map<LocalDate, JourTravail> joursDeTravail;

    public Calendrier() {
        joursDeTravail = new HashMap<>();
        initialiserCalendrier();
    }

    private void initialiserCalendrier() {
        for (int i = 1; i <= 30; i++) {
            LocalDate date = LocalDate.of(2024, Month.JUNE, i);
            boolean estFerie = (i == 17 || i == 25 || i == 26);
            boolean estDimanche = (date.getDayOfWeek() == java.time.DayOfWeek.SUNDAY);
            joursDeTravail.put(date, new JourTravail(date, estFerie, estDimanche));
        }
    }

    public JourTravail obtenirJour(LocalDate date) {
        return joursDeTravail.get(date);
    }

    public Map<LocalDate, JourTravail> obtenirJoursDeTravail() {
        return joursDeTravail;
    }
}

