package com.spring.gestionpointeuse.Repository;

import com.spring.gestionpointeuse.Entity.Absence;
import com.spring.gestionpointeuse.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long> {
}
