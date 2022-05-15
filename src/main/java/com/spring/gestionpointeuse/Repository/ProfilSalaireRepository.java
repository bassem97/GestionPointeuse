package com.spring.gestionpointeuse.Repository;

import com.spring.gestionpointeuse.Entity.ProfilSalaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilSalaireRepository extends JpaRepository<ProfilSalaire, Long> {
}
