package com.spring.gestionpointeuse.Service.Pause;

import com.spring.gestionpointeuse.Entity.Pause;
import com.spring.gestionpointeuse.Repository.PauseRepository;
import com.spring.gestionpointeuse.Service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PauseServiceImpl implements IPauseService, ICrudService<Pause,Long> {

    @Autowired
    private PauseRepository pauseRepository;

    @Override
    public Pause add(Pause pause) {
        return pauseRepository.save(pause);
    }

    @Override
    public Pause update(Pause pause, Long aLong) {
        if (pauseRepository.findById(aLong).isPresent()) {
            Pause pause1 = pauseRepository.findById(aLong).get();
            pause1.setDesignation(pause.getDesignation());
            pause1.setProfilCalendaire(pause.getProfilCalendaire());
            pause1.setTemps_obligatoire(pause.getTemps_obligatoire());
            pause1.setTemps_remunerer(pause.getTemps_remunerer());

            return pauseRepository.save(pause1);
        }
        return null;
    }

    @Override
    public void delete(Long aLong) {
        pauseRepository.deleteById(aLong);
    }

    @Override
    public List<Pause> findAll() {
        return pauseRepository.findAll();
    }

    @Override
    public Pause findById(Long aLong) {
        return pauseRepository.findById(aLong).get();
    }


}
