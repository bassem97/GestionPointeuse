package com.spring.gestionpointeuse.Service.Fonction;

import com.spring.gestionpointeuse.Entity.Fonction;
import com.spring.gestionpointeuse.Repository.FonctionRepository;
import com.spring.gestionpointeuse.Service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FonctionServiceImpl implements IFonctionService, ICrudService<Fonction,Long> {

    @Autowired
    private FonctionRepository fonctionRepository;

    @Override
    public Fonction add(Fonction fonction) {
        return fonctionRepository.save(fonction);
    }

    @Override
    public Fonction update(Fonction fonction, Long aLong) {
        if (fonctionRepository.findById(aLong).isPresent()) {
            Fonction fonction1 = fonctionRepository.findById(aLong).get();
            fonction1.setDesignation(fonction.getDesignation());
            fonction1.setFonctionalities(fonction.getFonctionalities());

            return fonctionRepository.save(fonction1);
        }
        return null;
    }

    @Override
    public void delete(Long aLong) {
        fonctionRepository.deleteById(aLong);
    }

    @Override
    public List<Fonction> findAll() {
        return fonctionRepository.findAll();
    }

    @Override
    public Fonction findById(Long aLong) {
        return fonctionRepository.findById(aLong).get();
    }


}
