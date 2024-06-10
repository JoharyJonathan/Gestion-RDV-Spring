package com.johary.rdvpt.services;

import org.springframework.stereotype.Service;

import com.johary.rdvpt.models.Rv;
import com.johary.rdvpt.repositories.RvRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RvService {
    
    private final RvRepository rvRepository;

    public RvService(RvRepository rvRepository)
    {
        this.rvRepository = rvRepository;
    }

    public List<Rv> getAllRv()
    {
        return (List<Rv>) rvRepository.findAll();
    }

    public Rv saveRv(Rv rv)
    {
        return rvRepository.save(rv);
    }

    public Optional<Rv> getRvById(Long id)
    {
        return rvRepository.findById(id);
    }

    public Rv updateRv(Rv rv)
    {
        return rvRepository.save(rv);
    }

    public void deleteRv(Long id)
    {
        rvRepository.deleteById(id);
    }
}
