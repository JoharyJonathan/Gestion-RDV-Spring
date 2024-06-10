package com.johary.rdvpt.services;

import com.johary.rdvpt.models.Patient;
import com.johary.rdvpt.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository)
    {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients()
    {
        return (List<Patient>) patientRepository.findAll();
    }

    public Patient savePatient(Patient patient)
    {
        return patientRepository.save(patient);
    }

    public Optional<Patient> getPatientById(Long id)
    {
        return patientRepository.findById(id);
    }

    public Patient updatePatient(Patient patient)
    {
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id)
    {
        patientRepository.deleteById(id);
    }
}
