package com.gsnotes.web.models;

public class FiliereModel {
    private Long idFiliere;
    private String titreFiliere;
    private String codeFiliere;
    private int anneeaccreditation;
    private int anneeFinaccreditation;
    private Long idCoordinateur;

    public Long getIdFiliere() {
        return idFiliere;
    }

    public String getTitreFiliere() {
        return titreFiliere;
    }

    public String getCodeFiliere() {
        return codeFiliere;
    }

    public int getAnneeaccreditation() {
        return anneeaccreditation;
    }

    public int getAnneeFinaccreditation() {
        return anneeFinaccreditation;
    }

    public Long getIdCoordinateur() { return idCoordinateur; }

    public void setIdFiliere(Long idFiliere) {
        this.idFiliere = idFiliere;
    }

    public void setTitreFiliere(String titreFiliere) {
        this.titreFiliere = titreFiliere;
    }

    public void setCodeFiliere(String codeFiliere) {
        this.codeFiliere = codeFiliere;
    }

    public void setAnneeaccreditation(int anneeaccreditation) {
        this.anneeaccreditation = anneeaccreditation;
    }

    public void setAnneeFinaccreditation(int anneeFinaccreditation) {
        this.anneeFinaccreditation = anneeFinaccreditation;
    }

    public void setIdCoordinateur(Long idCoordinateur) {
        this.idCoordinateur = idCoordinateur;
    }
}
