package com.spring.gestionpointeuse.Repository;

import com.spring.gestionpointeuse.Entity.Company;
import com.spring.gestionpointeuse.Entity.ProfilCalendaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilCalendaireRepository extends JpaRepository<ProfilCalendaire, Long> {
}
