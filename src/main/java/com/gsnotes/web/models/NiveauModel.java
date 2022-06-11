package com.gsnotes.web.models;

import com.gsnotes.bo.InscriptionAnnuelle;
import com.gsnotes.bo.Module;
import com.gsnotes.bo.Niveau;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

public class NiveauModel {
    private Long idNiveau;
    private String alias;
    private String titre;
    private Long idFiliere;

    public Long getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(Long idFiliere) {
        this.idFiliere = idFiliere;
    }

    public NiveauModel() {
    }

    public NiveauModel(Long idNiveau) {
        this.idNiveau = idNiveau;
    }

    public Long getIdNiveau() { return idNiveau; }
    public String getAlias() { return alias; }
    public String getTitre() { return titre; }

    public void setIdNiveau(Long idNiveau) { this.idNiveau = idNiveau; }
    public void setAlias(String alias) { this.alias = alias; }
    public void setTitre(String titre) { this.titre = titre; }

    public String toString() {
        return String.format("{idNiveau: %d, alias: %s, titre: %s}", idNiveau, alias, titre);
    }
}


