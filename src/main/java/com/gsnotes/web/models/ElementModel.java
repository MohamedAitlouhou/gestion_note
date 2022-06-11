package com.gsnotes.web.models;

import com.gsnotes.bo.Module;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ElementModel {
    private Long idMatiere;
    private String nom;
    private String code;
    private double currentCoefficient;
    private Long idModule;

    public ElementModel() {
    }

    public ElementModel(Long idMatiere) {
        this.idMatiere = idMatiere;
    }

    public Long getIdMatiere() {
        return idMatiere;
    }

    public String getNom() {
        return nom;
    }

    public String getCode() {
        return code;
    }

    public double getCurrentCoefficient() {
        return currentCoefficient;
    }

    public Long getIdModule() {
        return idModule;
    }

    public void setIdMatiere(Long idMatiere) {
        this.idMatiere = idMatiere;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCurrentCoefficient(double currentCoefficient) {
        this.currentCoefficient = currentCoefficient;
    }

    public void setIdModule(Long idModule) {
        this.idModule = idModule;
    }

    public String toString() {
        return String.format("{idMatiere: %d, nom: %s, code: %s, currentCoefficcient: %f, idModule: %d}",
                idMatiere, nom, code, currentCoefficient, idModule);
    }
}