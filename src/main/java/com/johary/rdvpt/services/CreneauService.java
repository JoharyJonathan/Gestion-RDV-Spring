package com.johary.rdvpt.services;

import com.johary.rdvpt.models.Creneaux;
import com.johary.rdvpt.repositories.CreneauRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class CreneauService {
    
    private final CreneauRepository creneauRepository;

    public CreneauService(CreneauRepository creneauRepository)
    {
        this.creneauRepository = creneauRepository;
    }

    public List<Creneaux> getAllCreneaux()
    {
        return creneauRepository.findAll();
    }

    public Creneaux saveCreneaux(Creneaux creneau)
    {
        return creneauRepository.save(creneau);
    }

    public Optional<Creneaux> getCreneauById(Long id)
    {
        return creneauRepository.findById(id);
    }

    public Creneaux updateCreneaux(Creneaux creneau)
    {
        return creneauRepository.save(creneau);
    }

    public void deleteCreneaux(Long id)
    {
        creneauRepository.deleteById(id);
    }
}
