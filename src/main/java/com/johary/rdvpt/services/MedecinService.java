package com.johary.rdvpt.services;

import com.johary.rdvpt.models.Medecin;
import com.johary.rdvpt.repositories.MedecinRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedecinService {
    
    private final MedecinRepository medecinRepository;

    public MedecinService(MedecinRepository medecinRepository)
    {
        this.medecinRepository = medecinRepository;
    }

    public List<Medecin> getAllMedecins()
    {
        return medecinRepository.findAll();
    }

    public Medecin saveMedecin(Medecin medecin)
    {
        return medecinRepository.save(medecin);
    }

    public Optional<Medecin> getMedecinById(Long id)
    {
        return medecinRepository.findById(id);
    }

    public Medecin updateMedecin(Medecin medecin)
    {
        return medecinRepository.save(medecin);
    }

    public void deleteMedecin(Long id)
    {
        medecinRepository.deleteById(id);
    }
}
