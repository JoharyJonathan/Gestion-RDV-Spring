package com.johary.rdvpt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.johary.rdvpt.models.Creneaux;

@Repository
public interface CreneauRepository extends JpaRepository<Creneaux, Long>{
    
}
