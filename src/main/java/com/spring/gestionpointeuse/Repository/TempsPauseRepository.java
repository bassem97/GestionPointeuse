package com.spring.gestionpointeuse.Repository;

import com.spring.gestionpointeuse.Entity.Pause;
import com.spring.gestionpointeuse.Entity.TempsPause;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempsPauseRepository extends JpaRepository<TempsPause, Long> {
}
