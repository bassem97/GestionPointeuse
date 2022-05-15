package com.spring.gestionpointeuse.Service.Evenement;

import com.spring.gestionpointeuse.Entity.Evenement;
import com.spring.gestionpointeuse.Repository.EvenementRepository;
import com.spring.gestionpointeuse.Service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EvenementServiceImpl implements IEvenementService, ICrudService<Evenement,Long> {

    @Autowired
    private EvenementRepository evenementRepository;

    @Override
    public Evenement add(Evenement evenement) {
        return evenementRepository.save(evenement);
    }

    @Override
    public Evenement update(Evenement evenement, Long aLong) {
        if (evenementRepository.findById(aLong).isPresent()) {
            Evenement evenement1 = evenementRepository.findById(aLong).get();
            evenement1.setDesignation(evenement.getDesignation());
            evenement1.setDatePointage(evenement.getDatePointage());
            evenement1.setEs(evenement.isEs());
            evenement1.setUsager(evenement.getUsager());

            return evenementRepository.save(evenement1);
        }
        return null;
    }

    @Override
    public void delete(Long aLong) {
        evenementRepository.deleteById(aLong);
    }

    @Override
    public List<Evenement> findAll() {
        return evenementRepository.findAll();
    }

    @Override
    public Evenement findById(Long aLong) {
        return evenementRepository.findById(aLong).get();
    }


}
