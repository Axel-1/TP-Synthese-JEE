package io.github.axel1.corpulenceweb.model.entity;

import io.github.axel1.corpulenceweb.calculateur.ICalculateurIMC;

public class Utilisateur {
    private final float poids;
    private final float taille;
    private ICalculateurIMC calculateurIMC;

    public Utilisateur(float poids, float taille, ICalculateurIMC calculateurIMC) {
        this.poids = poids;
        this.taille = taille;
        this.calculateurIMC = calculateurIMC;
    }

    public float getPoids() {
        return poids;
    }

    public float getTaille() {
        return taille;
    }

    public float getImc() {
        return calculateurIMC.calculerIMC(this.poids, this.taille);
    }

    public String getCorpulence() {
        return calculateurIMC.calculerCorpulence(this.getImc());
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "poids=" + poids +
                ", taille=" + taille +
                '}';
    }
}
