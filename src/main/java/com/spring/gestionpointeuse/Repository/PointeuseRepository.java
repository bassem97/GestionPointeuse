package com.spring.gestionpointeuse.Repository;

import com.spring.gestionpointeuse.Entity.Pointeuse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointeuseRepository extends JpaRepository<Pointeuse, Long> {
}
