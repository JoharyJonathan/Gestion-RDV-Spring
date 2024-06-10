package com.johary.rdvpt.controllers;

import com.johary.rdvpt.models.Creneaux;
import com.johary.rdvpt.models.Medecin;
import com.johary.rdvpt.services.CreneauService;
import com.johary.rdvpt.services.MedecinService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/creneaux")
public class CreneauController {

    private final CreneauService creneauService;
    private final MedecinService medecinService;

    public CreneauController(CreneauService creneauService, MedecinService medecinService) {
        this.creneauService = creneauService;
        this.medecinService = medecinService;
    }

    @GetMapping
    public String getAllCreneaux(Model model) {
        List<Creneaux> creneauxList = creneauService.getAllCreneaux();
        model.addAttribute("creneaux", creneauxList);
        return "creneaux/list";
    }

    @GetMapping("/{id}")
    public String getCreneauById(@PathVariable Long id, Model model) {
        Creneaux creneaux = creneauService.getCreneauById(id).orElse(null);
        model.addAttribute("creneaux", creneaux);
        return "creneaux/detail";
    }

    @GetMapping("/create")
    public String createCreneauxForm(Model model) {
        model.addAttribute("creneaux", new Creneaux());
        model.addAttribute("medecins", medecinService.getAllMedecins());
        return "creneaux/create";
    }

    @PostMapping
    public String createCreneaux(@ModelAttribute Creneaux creneaux) {
        Medecin medecin = medecinService.getMedecinById(creneaux.getMedecin().getId())
                           .orElseThrow(() -> new RuntimeException("Medecin not found"));
        creneaux.setMedecin(medecin);
        creneauService.saveCreneaux(creneaux);
        return "redirect:/creneaux";
    }

    @GetMapping("/edit/{id}")
    public String editCreneauxForm(@PathVariable Long id, Model model) {
        Creneaux creneaux = creneauService.getCreneauById(id).orElse(null);
        model.addAttribute("creneaux", creneaux);
        model.addAttribute("medecins", medecinService.getAllMedecins());
        return "creneaux/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateCreneaux(@PathVariable Long id, @ModelAttribute Creneaux updatedCreneaux) {
        updatedCreneaux.setId(id);
        Medecin medecin = medecinService.getMedecinById(updatedCreneaux.getMedecin().getId())
                           .orElseThrow(() -> new RuntimeException("Medecin not found"));
        updatedCreneaux.setMedecin(medecin);
        creneauService.updateCreneaux(updatedCreneaux);
        return "redirect:/creneaux";
    }

    @PostMapping("/delete/{id}")
    public String deleteCreneaux(@PathVariable Long id) {
        creneauService.deleteCreneaux(id);
        return "redirect:/creneaux";
    }
}
