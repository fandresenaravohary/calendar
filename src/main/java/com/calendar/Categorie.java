package com.calendar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categorie {
    private String nom;
    private int heuresNormalesParSemaine;
    private double salaireParSemaine;
    private double indemnite;
}

