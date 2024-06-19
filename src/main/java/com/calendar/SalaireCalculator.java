package com.calendar;

import java.time.LocalDate;

public class SalaireCalculator {

    public double calculerSalaire(Employe employe, Calendrier calendrier, int heuresTravaillees) {
        Categorie categorie = employe.getCategorie();
        int heuresNormalesParSemaine = categorie.getHeuresNormalesParSemaine();
        double salaireParSemaine = categorie.getSalaireParSemaine();
        double tauxHoraireNormal = salaireParSemaine / heuresNormalesParSemaine;

        double salaireBrut = 0;
        int heuresNormalesTotal = 0;
        int heuresSupplementairesTotal = 0;
        int heuresMajoreesTotal = 0;

        for (LocalDate date : calendrier.getJoursDeTravail().keySet()) {
            JourTravail jour = calendrier.obtenirJour(date);
            int heuresNormales = Math.min(8, heuresTravaillees);
            heuresNormalesTotal += heuresNormales;
            heuresTravaillees -= heuresNormales;

            if (heuresTravaillees > 0) {
                int heuresSupplementaires = Math.min(heuresTravaillees, 12);
                heuresSupplementairesTotal += heuresSupplementaires;
                heuresTravaillees -= heuresSupplementaires;

                if (heuresTravaillees > 0) {
                    int heuresMajorees = Math.min(heuresTravaillees, 20);
                    heuresMajoreesTotal += heuresMajorees;
                    heuresTravaillees -= heuresMajorees;
                }
            }

            double salaireJour = heuresNormales * tauxHoraireNormal;
            if (heuresSupplementairesTotal > 0) {
                salaireJour += heuresSupplementairesTotal * tauxHoraireNormal * 1.3;
            }
            if (heuresMajoreesTotal > 0) {
                salaireJour += heuresMajoreesTotal * tauxHoraireNormal * 1.5;
            }

            salaireBrut += salaireJour;
        }

        employe.setSalaireBrut(salaireBrut);
        employe.setSalaireNet(salaireBrut * 0.8);
        return employe.getSalaireNet();
    }
}

