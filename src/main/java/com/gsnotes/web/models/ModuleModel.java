package com.gsnotes.web.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ModuleModel {
    private Long idModule;

    @NotBlank(message = "This field is required")
    private String code;

    @NotBlank(message = "This field is required")
    private String titre;

    private Long idNiveau;

    public ModuleModel() {
    }

    public ModuleModel(Long idModule) {
        this.idModule = idModule;
    }

    public ModuleModel(Long idModule, String code, String titre, Long idNiveau) {
        this.idModule = idModule;
        this.code = code;
        this.titre = titre;
        this.idNiveau = idNiveau;
    }

    public Long getIdModule() {
        return idModule;
    }

    public String getCode() {
        return code;
    }

    public String getTitre() {
        return titre;
    }

    public Long getIdNiveau() {
        return idNiveau;
    }

    public void setIdModule(Long idModule) {
        this.idModule = idModule;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setIdNiveau(Long idNiveau) {
        this.idNiveau = idNiveau;
    }

    @Override
    public String toString() {
        return String.format("{idModule: %d, code: %s, titre: %s, idNiveau: %d}",
                idModule, code, titre, idNiveau);
    }
}
