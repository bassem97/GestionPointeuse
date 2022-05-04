package com.spring.gestionpointeuse.Repository;

import com.spring.gestionpointeuse.Entity.Fonctionalitie;
import com.spring.gestionpointeuse.Entity.Usager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FonctionalitieRepository extends JpaRepository<Fonctionalitie, Long> {
}
