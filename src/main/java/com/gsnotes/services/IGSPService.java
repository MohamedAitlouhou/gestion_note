package com.gsnotes.services;

import com.gsnotes.bo.Element;
import com.gsnotes.bo.Filiere;
import com.gsnotes.bo.Niveau;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.gsnotes.bo.Module;


public interface IGSPService {
    // Module
    public List<Module> getAllModules();
    public Module getModuleById(Long idModule);
    public void deleteModule(Long idModule);
    public void updateModule(Module module);

    // Element
    public List<Element> getAllElements();
    public Element getElementById(Long idElement);
    public void deleteElement(Long idElement);
    public void updateElement(Element element);

    // Niveau
    public List<Niveau> getAllNiveau();
    public Niveau getNiveauById(Long idNiveau);
    public void deleteNiveau(Long idNiveau);
    public void updateNiveau(Niveau niveau);

    // Filiere
    public List<Filiere> getAllFiliere();
    public Filiere getFiliereById(Long idFiliere);
    public void deleteFiliere(Long idFiliere);
    public void updateFiliere(Filiere filiere);

    // Importation
    public void importModules(String filename);
}
