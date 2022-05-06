package com.spring.gestionpointeuse.Repository;

import com.spring.gestionpointeuse.Entity.Fonction;
import com.spring.gestionpointeuse.Entity.Fonctionalitie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FonctionRepository extends JpaRepository<Fonction, Long> {
}
