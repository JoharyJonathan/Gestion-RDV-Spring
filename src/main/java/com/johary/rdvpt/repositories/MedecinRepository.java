package com.johary.rdvpt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.johary.rdvpt.models.Medecin;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin, Long>{
    
}
