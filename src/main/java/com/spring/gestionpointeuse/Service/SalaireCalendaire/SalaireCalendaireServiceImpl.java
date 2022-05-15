package com.spring.gestionpointeuse.Service.SalaireCalendaire;

import com.spring.gestionpointeuse.Entity.SalaireCalendaire;
import com.spring.gestionpointeuse.Repository.SalaireCalendaireRepository;
import com.spring.gestionpointeuse.Service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SalaireCalendaireServiceImpl implements ISalaireCalendaireService, ICrudService<SalaireCalendaire,Long> {

    @Autowired
    private SalaireCalendaireRepository salaireCalendaireRepository;

    @Override
    public SalaireCalendaire add(SalaireCalendaire salaireCalendaire) {
        return salaireCalendaireRepository.save(salaireCalendaire);
    }

    @Override
    public SalaireCalendaire update(SalaireCalendaire salaireCalendaire, Long aLong) {
        if (salaireCalendaireRepository.findById(aLong).isPresent()) {
            SalaireCalendaire salaireCalendaire1 = salaireCalendaireRepository.findById(aLong).get();
            salaireCalendaire1.setJourSemaine(salaireCalendaire.getJourSemaine());
            salaireCalendaire1.setProfilSalaire(salaireCalendaire.getProfilSalaire());
            salaireCalendaire1.setProfilCalendaire(salaireCalendaire.getProfilCalendaire());

            return salaireCalendaireRepository.save(salaireCalendaire1);
        }
        return null;
    }

    @Override
    public void delete(Long aLong) {
        salaireCalendaireRepository.deleteById(aLong);
    }

    @Override
    public List<SalaireCalendaire> findAll() {
        return salaireCalendaireRepository.findAll();
    }

    @Override
    public SalaireCalendaire findById(Long aLong) {
        return salaireCalendaireRepository.findById(aLong).get();
    }


}
