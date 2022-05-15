package com.spring.gestionpointeuse.Service.ProfilSalaire;

import com.spring.gestionpointeuse.Entity.ProfilSalaire;
import com.spring.gestionpointeuse.Repository.ProfilSalaireRepository;
import com.spring.gestionpointeuse.Service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfilSalaireServiceImpl implements IProfilSalaireService, ICrudService<ProfilSalaire,Long> {

    @Autowired
    private ProfilSalaireRepository profilSalaireRepository;

    @Override
    public ProfilSalaire add(ProfilSalaire profilSalaire) {
        return profilSalaireRepository.save(profilSalaire);
    }

    @Override
    public ProfilSalaire update(ProfilSalaire profilSalaire, Long aLong) {
        if (profilSalaireRepository.findById(aLong).isPresent()) {
            ProfilSalaire profilSalaire1 = profilSalaireRepository.findById(aLong).get();
            profilSalaire1.setDesignation(profilSalaire.getDesignation());
            profilSalaire1.setHorraireMatin(profilSalaire.getHorraireMatin());
            profilSalaire1.setHorraireSoir(profilSalaire.getHorraireSoir());
            profilSalaire1.setJourDebutAnnee(profilSalaire.getJourDebutAnnee());
            profilSalaire1.setTraitementRtt(profilSalaire.getTraitementRtt());

            return profilSalaireRepository.save(profilSalaire1);
        }
        return null;
    }

    @Override
    public void delete(Long aLong) {
        profilSalaireRepository.deleteById(aLong);
    }

    @Override
    public List<ProfilSalaire> findAll() {
        return profilSalaireRepository.findAll();
    }

    @Override
    public ProfilSalaire findById(Long aLong) {
        return profilSalaireRepository.findById(aLong).get();
    }


}
