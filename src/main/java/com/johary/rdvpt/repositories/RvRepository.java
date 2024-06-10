package com.johary.rdvpt.repositories;

import com.johary.rdvpt.models.Rv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RvRepository extends JpaRepository<Rv, Long>{
    
}
