package io.github.axel1.corpulenceweb.calculateur;

public interface ICalculateurIMC {
    float calculerIMC(float poids, float taille);
    String calculerCorpulence(float imc);
}
