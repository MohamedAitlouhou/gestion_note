package com.gsnotes.services.impl;

import com.gsnotes.dao.IElementDao;
import com.gsnotes.dao.IFiliereDao;
import com.gsnotes.dao.IModuleDao;
import com.gsnotes.dao.INiveauDao;
import com.gsnotes.services.IGSPService;
import com.gsnotes.utils.ExcelImporter;
import org.springframework.beans.factory.annotation.Autowired;
import com.gsnotes.bo.Module;
import com.gsnotes.bo.Niveau;
import com.gsnotes.bo.Element;
import com.gsnotes.bo.Filiere;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GSPServiceImpl implements IGSPService {
    @Autowired
    private IModuleDao moduleDao;
    @Autowired
    private INiveauDao niveauDao;
    @Autowired
    private IElementDao elementDao;
    @Autowired
    private IFiliereDao filiereDao;
    public List<Module> getAllModules() {
        return moduleDao.findAll();
    }
    public Module getModuleById(Long idModule) {
        return moduleDao.getById(idModule);
    }
    public void deleteModule(Long idModule) {
        moduleDao.deleteById(idModule);
    }
    public void updateModule(Module module) {
        moduleDao.save(module);
    }

    public List<Element> getAllElements() { return elementDao.findAll(); }
    public Element getElementById(Long idElement) { return elementDao.getById(idElement); }
    public void deleteElement(Long idElement) { elementDao.deleteById(idElement); }
    public void updateElement(Element element) { elementDao.save(element); }

    public List<Niveau> getAllNiveau() { return niveauDao.findAll(); }
    public Niveau getNiveauById(Long idNiveau) { return niveauDao.getById(idNiveau); }
    public void deleteNiveau(Long idNiveau) { niveauDao.deleteById(idNiveau); }
    public void updateNiveau(Niveau niveau) { niveauDao.save(niveau); }

    public List<Filiere> getAllFiliere() { return filiereDao.findAll(); }
    public Filiere getFiliereById(Long idFiliere) { return filiereDao.getById(idFiliere); }
    public void deleteFiliere(Long idFiliere) { filiereDao.deleteById(idFiliere); }
    public void updateFiliere(Filiere filiere) { filiereDao.save(filiere); }

    public void importModules(String filename) {
        List<ArrayList<Object>> data = ExcelImporter.importExcel(filename);
        for (int i = 1; i < data.size(); i++) {
            String code = (String) data.get(i).get(0);
            String titre = (String) data.get(i).get(1);
            String niveau = (String) data.get(i).get(2);

            Niveau nv = niveauDao.getNiveauByTitre(niveau);

            Module module = new Module();
            module.setCode(code);
            module.setTitre(titre);
            module.setNiveau(nv);

            moduleDao.save(module);
        }
    }
}
