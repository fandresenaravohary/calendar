package com.calendar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employe {
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private LocalDate dateEmbauche;
    private LocalDate dateFinContrat;
    private double salaireBrut;
    private double salaireNet;
    private Categorie categorie;

    public Employe(String nom, String prenom, LocalDate dateNaissance, LocalDate dateEmbauche, LocalDate dateFinContrat, double salaireBrut, Categorie categorie) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.dateEmbauche = dateEmbauche;
        this.dateFinContrat = dateFinContrat;
        this.salaireBrut = salaireBrut;
        this.salaireNet = calculerSalaireNet(salaireBrut);
        this.categorie = categorie;
    }

    private double calculerSalaireNet(double salaireBrut) {
        return salaireBrut * 0.80;
    }
}

