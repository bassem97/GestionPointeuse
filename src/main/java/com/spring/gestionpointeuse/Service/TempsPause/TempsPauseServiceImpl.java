package com.spring.gestionpointeuse.Service.TempsPause;

import com.spring.gestionpointeuse.Entity.TempsPause;
import com.spring.gestionpointeuse.Repository.TempsPauseRepository;
import com.spring.gestionpointeuse.Service.ICrudService;
import com.spring.gestionpointeuse.Service.TempsPause.ITempsPauseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TempsPauseServiceImpl implements ITempsPauseService, ICrudService<TempsPause,Long> {

    @Autowired
    private TempsPauseRepository tempsPauseRepository;

    @Override
    public TempsPause add(TempsPause tempsPause) {
        return tempsPauseRepository.save(tempsPause);
    }

    @Override
    public TempsPause update(TempsPause tempsPause, Long aLong) {
        if (tempsPauseRepository.findById(aLong).isPresent()) {
            TempsPause tempsPause1 = tempsPauseRepository.findById(aLong).get();
            tempsPause1.setDateDebut(tempsPause.getDateDebut());
            tempsPause1.setDateFin(tempsPause.getDateFin());
            tempsPause1.setPause(tempsPause.getPause());

            return tempsPauseRepository.save(tempsPause1);
        }
        return null;
    }

    @Override
    public void delete(Long aLong) {
        tempsPauseRepository.deleteById(aLong);
    }

    @Override
    public List<TempsPause> findAll() {
        return tempsPauseRepository.findAll();
    }

    @Override
    public TempsPause findById(Long aLong) {
        return tempsPauseRepository.findById(aLong).get();
    }


}
