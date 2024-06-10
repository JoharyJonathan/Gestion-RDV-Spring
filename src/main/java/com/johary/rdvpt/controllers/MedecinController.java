package com.johary.rdvpt.controllers;

import com.johary.rdvpt.models.Medecin;
import com.johary.rdvpt.services.MedecinService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/medecins")
public class MedecinController {

    private final MedecinService medecinService;

    public MedecinController(MedecinService medecinService) {
        this.medecinService = medecinService;
    }

    @GetMapping
    public String getAllMedecins(Model model) {
        List<Medecin> medecins = medecinService.getAllMedecins();
        model.addAttribute("medecins", medecins);
        return "medecins/list";
    }

    @GetMapping("/{id}")
    public String getMedecinById(@PathVariable Long id, Model model) {
        Medecin medecin = medecinService.getMedecinById(id).orElse(null);
        model.addAttribute("medecin", medecin);
        return "medecins/detail";
    }

    @GetMapping("/create")
    public String createMedecinForm(Model model) {
        model.addAttribute("medecin", new Medecin());
        return "medecins/create";
    }

    @PostMapping
    public String createMedecin(@ModelAttribute Medecin medecin) {
        medecinService.saveMedecin(medecin);
        return "redirect:/medecins";
    }

    @GetMapping("/edit/{id}")
    public String editMedecinForm(@PathVariable Long id, Model model) {
        Medecin medecin = medecinService.getMedecinById(id).orElse(null);
        model.addAttribute("medecin", medecin);
        return "medecins/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateMedecin(@PathVariable Long id, @ModelAttribute Medecin updatedMedecin) {
        updatedMedecin.setId(id);
        medecinService.updateMedecin(updatedMedecin);
        return "redirect:/medecins";
    }

    @PostMapping("/delete/{id}")
    public String deleteMedecin(@PathVariable Long id) {
        medecinService.deleteMedecin(id);
        return "redirect:/medecins";
    }
}
