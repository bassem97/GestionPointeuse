package com.spring.gestionpointeuse.Repository;

import com.spring.gestionpointeuse.Entity.Usager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsagerRepository extends JpaRepository<Usager, Long> {

    Usager findByEmail(String email);
}
