package com.spring.gestionpointeuse.Repository;

import com.spring.gestionpointeuse.Entity.SalaireCalendaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaireCalendaireRepository extends JpaRepository<SalaireCalendaire, Long> {
}
