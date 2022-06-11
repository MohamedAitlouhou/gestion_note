package com.gsnotes.web.controllers;

import com.gsnotes.bo.Element;
import com.gsnotes.bo.Filiere;
import com.gsnotes.bo.Module;
import com.gsnotes.bo.Niveau;
import com.gsnotes.dao.IUtilisateurDao;
import com.gsnotes.services.IGSPService;
import com.gsnotes.web.models.*;
import org.apache.tomcat.jni.File;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cadreadmin")
public class GSPController {

    @Autowired
    private IGSPService gspService;

    @Autowired
    private IUtilisateurDao userDao;

    @Autowired
    ServletContext context;

    /********************************************* MODULES ************************************************/

    @GetMapping("modules")
    public String listeModules(Model model) {

        List<Module> modules = gspService.getAllModules();
        List<ModuleModel> modelModules = new ArrayList<ModuleModel>();

        for (int i = 0; i < modules.size(); i++) {
            ModuleModel mm = new ModuleModel();
            BeanUtils.copyProperties(modules.get(i), mm);
            mm.setIdNiveau(modules.get(i).getNiveau().getIdNiveau());
            modelModules.add(mm);
        }

        model.addAttribute("modulesList", modelModules);

        return "cadreadmin/modules";
    }

    @GetMapping("deleteModule/{idModule}")
    public String deleteModel(@PathVariable int idModule) {
        gspService.deleteModule(Long.valueOf(idModule));
        return "redirect:/cadreadmin/modules";
    }

    @GetMapping("updateModuleForm/{idModule}")
    public String updateModuleForm(@PathVariable int idModule, Model model) {
        Module module = gspService.getModuleById(Long.valueOf(idModule));
        ModuleModel mm = new ModuleModel();
        BeanUtils.copyProperties(module, mm);
        mm.setIdNiveau(module.getNiveau().getIdNiveau());
        model.addAttribute("module", mm);
        model.addAttribute("niveaux", gspService.getAllNiveau());
        return "cadreadmin/updateModuleForm";
    }

    @GetMapping("updateModule")
    public String updateModule(@Valid @ModelAttribute("module") ModuleModel mm, Model model) {
        Module module = new Module();
        BeanUtils.copyProperties(mm, module);
        module.setNiveau(gspService.getModuleById(module.getIdModule()).getNiveau());
        gspService.updateModule(module);
        return "redirect:/cadreadmin/modules";
    }

    @GetMapping("createModuleForm")
    public String createModuleForm(Model model) {
        model.addAttribute("module", new ModuleModel());
        model.addAttribute("niveaux", gspService.getAllNiveau());
        return "cadreadmin/createModuleForm";
    }

    @GetMapping("createModule")
    public String createModule(@Valid @ModelAttribute("module") ModuleModel mm) {
        Module module = new Module();
        BeanUtils.copyProperties(mm, module);
        module.setNiveau(gspService.getNiveauById(mm.getIdNiveau()));
        gspService.updateModule(module);
        return "redirect:/cadreadmin/modules";
    }

    /********************************************* ELEMENTS ************************************************/

    @GetMapping("elements")
    public String listeElements(Model model) {

        List<Element> elements = gspService.getAllElements();
        List<ElementModel> modelElements = new ArrayList<ElementModel>();

        for (int i = 0; i < elements.size(); i++) {
            ElementModel em = new ElementModel();
            BeanUtils.copyProperties(elements.get(i), em);
            em.setIdModule(elements.get(i).getModule().getIdModule());
            modelElements.add(em);
        }

        model.addAttribute("elementsList", modelElements);

        return "cadreadmin/elements";
    }

    @GetMapping("deleteElement/{idMatiere}")
    public String deleteElement(@PathVariable int idMatiere) {
        gspService.deleteElement(Long.valueOf(idMatiere));
        return "redirect:/cadreadmin/elements";
    }

    @GetMapping("updateElementForm/{idMatiere}")
    public String updateElementForm(@PathVariable int idMatiere, Model model) {
        Element element = gspService.getElementById(Long.valueOf(idMatiere));
        ElementModel em = new ElementModel();
        BeanUtils.copyProperties(element, em);
        em.setIdModule(element.getModule().getIdModule());
        model.addAttribute("element", em);
        model.addAttribute("modules", gspService.getAllModules());
        return "cadreadmin/updateElementForm";
    }

    @GetMapping("updateElement")
    public String updateElement(@Valid @ModelAttribute("element") ElementModel em, Model model) {
        Element element = new Element();
        BeanUtils.copyProperties(em, element);
        element.setModule(gspService.getModuleById(em.getIdModule()));
        gspService.updateElement(element);
        return "redirect:/cadreadmin/elements";
    }

    @GetMapping("createElementForm")
    public String createElementForm(Model model) {
        model.addAttribute("element", new ElementModel());
        model.addAttribute("modules", gspService.getAllModules());
        return "cadreadmin/createElementForm";
    }

    @GetMapping("createElement")
    public String createModule(@Valid @ModelAttribute("element") ElementModel em) {
        Element element = new Element();
        BeanUtils.copyProperties(em, element);
        element.setModule(gspService.getModuleById(em.getIdModule()));
        gspService.updateElement(element);
        return "redirect:/cadreadmin/elements";
    }

    /********************************************* NIVEAUX ************************************************/

    @GetMapping("niveaux")
    public String listeNiveaux(Model model) {

        List<Niveau> elements = gspService.getAllNiveau();
        List<NiveauModel> niveauElements = new ArrayList<NiveauModel>();

        for (int i = 0; i < elements.size(); i++) {
            NiveauModel nm = new NiveauModel();
            BeanUtils.copyProperties(elements.get(i), nm);
            nm.setIdFiliere(elements.get(i).getFiliere().getIdFiliere());
            niveauElements.add(nm);
        }

        model.addAttribute("niveauxList", niveauElements);

        return "cadreadmin/niveaux";
    }

    @GetMapping("deleteNiveau/{idNiveau}")
    public String deleteNiveau(@PathVariable int idNiveau) {
        gspService.deleteNiveau(Long.valueOf(idNiveau));
        return "redirect:/cadreadmin/niveaux";
    }

    @GetMapping("updateNiveauForm/{idNiveau}")
    public String updateNiveauForm(@PathVariable int idNiveau, Model model) {
        Niveau niveau = gspService.getNiveauById(Long.valueOf(idNiveau));
        NiveauModel nm = new NiveauModel();
        BeanUtils.copyProperties(niveau, nm);
        model.addAttribute("niveau", nm);
        model.addAttribute("filieres", gspService.getAllFiliere());
        return "cadreadmin/updateNiveauForm";
    }

    @GetMapping("updateNiveau")
    public String updateNiveau(@Valid @ModelAttribute("niveau") NiveauModel nm, Model model) {
        Niveau niveau = new Niveau();
        BeanUtils.copyProperties(nm, niveau);
        niveau.setFiliere(gspService.getFiliereById(nm.getIdFiliere()));
        gspService.updateNiveau(niveau);
        return "redirect:/cadreadmin/niveaux";
    }

    @GetMapping("createNiveauForm")
    public String createNiveauForm(Model model) {
        model.addAttribute("niveau", new NiveauModel());
        model.addAttribute("filieres", gspService.getAllFiliere());
        return "cadreadmin/createNiveauForm";
    }

    @GetMapping("createNiveau")
    public String createNiveau(@Valid @ModelAttribute("niveau") NiveauModel nm) {
        Niveau niveau = new Niveau();
        BeanUtils.copyProperties(nm, niveau);
        niveau.setFiliere(gspService.getFiliereById(nm.getIdFiliere()));
        gspService.updateNiveau(niveau);
        return "redirect:/cadreadmin/niveaux";
    }

    /********************************************* FILIERES ************************************************/

    @GetMapping("filieres")
    public String listeFilieres(Model model) {

        List<Filiere> filieres = gspService.getAllFiliere();
        List<FiliereModel> filiereElements = new ArrayList<FiliereModel>();

        for (int i = 0; i < filieres.size(); i++) {
            FiliereModel fm = new FiliereModel();
            BeanUtils.copyProperties(filieres.get(i), fm);
            filiereElements.add(fm);
        }

        model.addAttribute("filiereList", filiereElements);

        return "cadreadmin/filieres";
    }

    @GetMapping("deleteFiliere/{idFiliere}")
    public String deleteFiliere(@PathVariable int idFiliere) {
        gspService.deleteFiliere(Long.valueOf(idFiliere));
        return "redirect:/cadreadmin/filieres";
    }

    @GetMapping("updateFiliereForm/{idFiliere}")
    public String updateFiliereForm(@PathVariable int idFiliere, Model model) {
        Filiere filiere = gspService.getFiliereById(Long.valueOf(idFiliere));
        FiliereModel fm = new FiliereModel();
        BeanUtils.copyProperties(filiere, fm);
        model.addAttribute("filiere", fm);
        return "cadreadmin/updateFiliereForm";
    }

    @GetMapping("updateFiliere")
    public String updateFiliere(@Valid @ModelAttribute("filiere") FiliereModel fm, Model model) {
        Filiere filiere = new Filiere();
        BeanUtils.copyProperties(fm, filiere);
        gspService.updateFiliere(filiere);
        return "redirect:/cadreadmin/filieres";
    }

    @GetMapping("createFiliereForm")
    public String createFiliereForm(Model model) {
        model.addAttribute("filiere", new FiliereModel());
        return "cadreadmin/createFiliereForm";
    }

    @GetMapping("createFiliere")
    public String createFiliere(@Valid @ModelAttribute("filiere") FiliereModel fm) {
        Filiere filiere = new Filiere();
        BeanUtils.copyProperties(fm, filiere);
        filiere.setIdCoordinateur(8L);
        gspService.updateFiliere(filiere);
        return "redirect:/cadreadmin/filieres";
    }

    /********************************************* AFFECTER COORDINATEUR A UNE FILIERE ************************************************/

    @GetMapping("/affecterCoordFiliereForm")
    public String affecterCoordFiliere(Model model) {
        model.addAttribute("affectCoordModel", new AffectCoordModel());
        model.addAttribute("filieres", gspService.getAllFiliere());
        model.addAttribute("coordinateurs", userDao.findAll());
        return "/cadreadmin/affecterCoordFiliereForm";
    }

    @GetMapping("/affecterCoordFiliere")
    public String affecterCoordFiliere(@ModelAttribute("affectCoordModel") AffectCoordModel model, RedirectAttributes attr) {
        Filiere filiere = gspService.getFiliereById(model.getIdFiliere());
        filiere.setIdCoordinateur(model.getIdCoordinateur());
        gspService.updateFiliere(filiere);
        attr.addFlashAttribute("message", "coordonateur affecte avec succes");
        return "redirect:/cadreadmin/affecterCoordFiliereForm";
    }


    /********************************************* IMPORTATION DE LA STRUCTURE PEDAGOGIQUE ************************************************/

    @GetMapping("importSpForm")
    public String importSpForm() {
        return "/cadreadmin/importSpForm";
    }

    @PostMapping("import")
    public String importSp(@RequestParam("modules") MultipartFile modulesFile,
                           @RequestParam("elements") MultipartFile elementsFile,
                           @RequestParam("filieres") MultipartFile filieresFile,
                           @RequestParam("niveaux") MultipartFile niveauxFile) throws IOException {

        Files.copy(modulesFile.getInputStream(), Paths.get(context.getRealPath("uploads") + modulesFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        Files.copy(elementsFile.getInputStream(), Paths.get(context.getRealPath("uploads") + elementsFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        Files.copy(filieresFile.getInputStream(), Paths.get(context.getRealPath("uploads") + filieresFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        Files.copy(niveauxFile.getInputStream(), Paths.get(context.getRealPath("uploads") + niveauxFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        gspService.importModules(Paths.get(context.getRealPath("uploads") + modulesFile.getOriginalFilename()).toString());

        return "test";
    }
}
