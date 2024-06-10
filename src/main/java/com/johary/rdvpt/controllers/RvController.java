package com.johary.rdvpt.controllers;

import com.johary.rdvpt.models.Rv;
import com.johary.rdvpt.models.Patient;
import com.johary.rdvpt.models.Creneaux;
import com.johary.rdvpt.services.RvService;
import com.johary.rdvpt.services.PatientService;
import com.johary.rdvpt.services.CreneauService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rdv")
public class RvController {

    private final RvService rvService;
    private final PatientService patientService;
    private final CreneauService creneauService;

    public RvController(RvService rvService, PatientService patientService, CreneauService creneauService) {
        this.rvService = rvService;
        this.patientService = patientService;
        this.creneauService = creneauService;
    }

    @GetMapping
    public String getAllRv(Model model) {
        List<Rv> rvList = rvService.getAllRv();
        model.addAttribute("rvList", rvList);
        return "rdv/list";
    }

    @GetMapping("/{id}")
    public String getRvById(@PathVariable Long id, Model model) {
        Rv rv = rvService.getRvById(id).orElse(null);
        model.addAttribute("rv", rv);
        return "rdv/detail";
    }

    @GetMapping("/create")
    public String createRvForm(Model model) {
        model.addAttribute("rv", new Rv());
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("creneaux", creneauService.getAllCreneaux());
        return "rdv/create";
    }

    @PostMapping
    public String createRv(@ModelAttribute Rv rv, @RequestParam Long patientId, @RequestParam Long creneauId) {
        Patient patient = patientService.getPatientById(patientId).orElseThrow(() -> new RuntimeException("Patient not found"));
        Creneaux creneaux = creneauService.getCreneauById(creneauId).orElseThrow(() -> new RuntimeException("Creneaux not found"));
        rv.setPatient(patient);
        rv.setCreneau(creneaux);
        rvService.saveRv(rv);
        return "redirect:/rdv";
    }

    @GetMapping("/edit/{id}")
    public String editRvForm(@PathVariable Long id, Model model) {
        Rv rv = rvService.getRvById(id).orElse(null);
        model.addAttribute("rv", rv);
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("creneaux", creneauService.getAllCreneaux());
        return "rdv/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateRv(@PathVariable Long id, @ModelAttribute Rv updatedRv, @RequestParam Long patientId, @RequestParam Long creneauId) {
        updatedRv.setId(id);
        Patient patient = patientService.getPatientById(patientId).orElseThrow(() -> new RuntimeException("Patient not found"));
        Creneaux creneaux = creneauService.getCreneauById(creneauId).orElseThrow(() -> new RuntimeException("Creneaux not found"));
        updatedRv.setPatient(patient);
        updatedRv.setCreneau(creneaux);
        rvService.updateRv(updatedRv);
        return "redirect:/rdv";
    }

    @PostMapping("/delete/{id}")
    public String deleteRv(@PathVariable Long id) {
        rvService.deleteRv(id);
        return "redirect:/rdv";
    }
}
