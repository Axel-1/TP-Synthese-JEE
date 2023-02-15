package io.github.axel1.corpulenceweb.model.service;

import io.github.axel1.corpulenceweb.calculateur.ICalculateurIMC;
import io.github.axel1.corpulenceweb.model.entity.Utilisateur;

import java.util.ArrayList;
import java.util.List;

public class IMCService {
    private List<Float> IMCs;
    private ICalculateurIMC calculateurIMC;

    public IMCService(ICalculateurIMC calculateurIMC) {
        this.IMCs = new ArrayList<>();
        this.calculateurIMC = calculateurIMC;
    }

    private void addIMC(float imc) {
        IMCs.add(imc);
    }

    public float getImc(float poids, float taille) {
        var utilisateur = new Utilisateur(poids, taille, calculateurIMC);
        var IMC = utilisateur.getImc();
        addIMC(IMC);
        return IMC;
    }

    public String getCorpulence(float poids, float taille) {
        var utilisateur = new Utilisateur(poids, taille, calculateurIMC);
        return utilisateur.getCorpulence();
    }

    public float getMoyenne() {
        if (IMCs.size() == 0) {
            return 0;
        }
        float somme = 0;
        for (Float imc : IMCs) {
            somme += imc;
        }
        return somme / IMCs.size();
    }
}
