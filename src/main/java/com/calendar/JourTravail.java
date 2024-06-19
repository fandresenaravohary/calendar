package com.calendar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JourTravail {
    private LocalDate date;
    private boolean estFerie;
    private boolean estDimanche;
    private int heuresNormales;
    private int heuresSupplementaires;
    private int heuresMajorees;

    public JourTravail(LocalDate date, boolean estFerie, boolean estDimanche) {
        this.date = date;
        this.estFerie = estFerie;
        this.estDimanche = estDimanche;
        this.heuresNormales = 0;
        this.heuresSupplementaires = 0;
        this.heuresMajorees = 0;
    }

    public void ajouterHeures(int heuresNormales, int heuresSupplementaires, int heuresMajorees) {
        this.heuresNormales += heuresNormales;
        this.heuresSupplementaires += heuresSupplementaires;
        this.heuresMajorees += heuresMajorees;
    }
}

