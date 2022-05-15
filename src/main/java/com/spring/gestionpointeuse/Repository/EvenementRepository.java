package com.spring.gestionpointeuse.Repository;

import com.spring.gestionpointeuse.Entity.Absence;
import com.spring.gestionpointeuse.Entity.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {
}
