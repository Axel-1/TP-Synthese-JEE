package io.github.axel1.corpulenceweb.calculateur;

public class CalculateurIMC implements ICalculateurIMC {
    @Override
    public float calculerIMC(float poids, float taille) {
        return poids / (taille * taille);
    }

    @Override
    public String calculerCorpulence(float imc) {
        if (imc < 16.5) {
            return "dénutrition";
        } else if (imc < 18.5) {
            return "maigreur";
        } else if (imc < 25) {
            return "corpulence normale";
        } else if (imc < 30) {
            return "surpoids";
        } else if (imc < 35) {
            return "obésité modérée";
        } else if (imc < 40) {
            return "obésité sévère";
        } else {
            return "obésité morbide ou massive";
        }
    }
}
