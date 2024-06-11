package com.johary.rdvpt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.johary.rdvpt.models.Creneaux;

@Repository
public interface CreneauRepository extends JpaRepository<Creneaux, Long>{
    List<Creneaux> findByMedecinId(Long medecinId);
}
