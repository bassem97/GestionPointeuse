package com.spring.gestionpointeuse.Service.Fonctionalitie;

import com.spring.gestionpointeuse.Entity.Fonctionalitie;
import com.spring.gestionpointeuse.Repository.FonctionalitieRepository;
import com.spring.gestionpointeuse.Service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FonctionalitieServiceImpl implements IFonctionalitieService, ICrudService<Fonctionalitie,Long> {

    @Autowired
    private FonctionalitieRepository fonctionalitieRepository;

    @Override
    public Fonctionalitie add(Fonctionalitie fonctionalitie) {
        return fonctionalitieRepository.save(fonctionalitie);
    }

    @Override
    public Fonctionalitie update(Fonctionalitie fonctionalitie, Long aLong) {
        if (fonctionalitieRepository.findById(aLong).isPresent()) {
            Fonctionalitie fonctionalitie1 = fonctionalitieRepository.findById(aLong).get();
            fonctionalitie1.setAjout(fonctionalitie.getAjout());
            fonctionalitie1.setModification(fonctionalitie.getModification());
            fonctionalitie1.setSuppression(fonctionalitie.getSuppression());
            fonctionalitie1.setLecture(fonctionalitie.getLecture());
            fonctionalitie1.setUsager(fonctionalitie.getUsager());

            return fonctionalitieRepository.save(fonctionalitie1);
        }
        return null;
    }

    @Override
    public void delete(Long aLong) {
        fonctionalitieRepository.deleteById(aLong);
    }

    @Override
    public List<Fonctionalitie> findAll() {
        return fonctionalitieRepository.findAll();
    }

    @Override
    public Fonctionalitie findById(Long aLong) {
        return fonctionalitieRepository.findById(aLong).get();
    }


}
