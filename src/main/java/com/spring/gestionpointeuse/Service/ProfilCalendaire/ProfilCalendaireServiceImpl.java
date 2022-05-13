package com.spring.gestionpointeuse.Service.ProfilCalendaire;

import com.spring.gestionpointeuse.Entity.Details;
import com.spring.gestionpointeuse.Entity.ProfilCalendaire;
import com.spring.gestionpointeuse.Repository.ProfilCalendaireRepository;
import com.spring.gestionpointeuse.Service.ICrudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfilCalendaireServiceImpl implements IProfilCalendaireService, ICrudService<ProfilCalendaire,Long> {

    private ProfilCalendaireRepository profilCalendaireRepository;


    @Override
    public ProfilCalendaire add(ProfilCalendaire profilCalendaire) {
        return profilCalendaireRepository.save(profilCalendaire);
    }

    @Override
    public ProfilCalendaire update(ProfilCalendaire profilCalendaire, Long id) {
        if (profilCalendaireRepository.findById(id).isPresent()) {
            ProfilCalendaire profilCalendaire1 = profilCalendaireRepository.findById(id).get();
            profilCalendaire1.setCompany(profilCalendaire.getCompany());
            profilCalendaire1.setCouvrant(profilCalendaire.getCouvrant());
            profilCalendaire1.setDefinition(profilCalendaire.getDefinition());
            profilCalendaire1.setDesignation(profilCalendaire.getDesignation());
            profilCalendaire1.setEnrcetee(profilCalendaire.getEnrcetee());
            profilCalendaire1.setUsePointeuse(profilCalendaire.isUsePointeuse());


            return profilCalendaireRepository.save(profilCalendaire1);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        profilCalendaireRepository.deleteById(id);
    }

    @Override
    public List<ProfilCalendaire> findAll() {
        return profilCalendaireRepository.findAll();
    }

    @Override
    public ProfilCalendaire findById(Long id) {
        return profilCalendaireRepository.findById(id).isPresent() ?
                profilCalendaireRepository.findById(id).get() :
                null;
    }
}
