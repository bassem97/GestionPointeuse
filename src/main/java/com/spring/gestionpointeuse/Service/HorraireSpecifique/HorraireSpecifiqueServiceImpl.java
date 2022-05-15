package com.spring.gestionpointeuse.Service.HorraireSpecifique;

import com.spring.gestionpointeuse.Entity.HorraireSpecifique;
import com.spring.gestionpointeuse.Repository.HorraireSpecifiqueRepository;
import com.spring.gestionpointeuse.Service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HorraireSpecifiqueServiceImpl implements IHorraireSpecifiqueService, ICrudService<HorraireSpecifique,Long> {

    @Autowired
    private HorraireSpecifiqueRepository horraireSpecifiqueRepository;

    @Override
    public HorraireSpecifique add(HorraireSpecifique horraireSpecifique) {
        return horraireSpecifiqueRepository.save(horraireSpecifique);
    }

    @Override
    public HorraireSpecifique update(HorraireSpecifique horraireSpecifique, Long aLong) {
        if (horraireSpecifiqueRepository.findById(aLong).isPresent()) {
            HorraireSpecifique horraireSpecifique1 = horraireSpecifiqueRepository.findById(aLong).get();
            horraireSpecifique1.setDefinition(horraireSpecifique.getDefinition());
            horraireSpecifique1.setMontant(horraireSpecifique.getMontant());
            horraireSpecifique1.setHoraireSpec(horraireSpecifique.getHoraireSpec());
            horraireSpecifique1.setProfilCalendaire(horraireSpecifique.getProfilCalendaire());
            horraireSpecifique1.setReprisePointage(horraireSpecifique.getReprisePointage());
            horraireSpecifique1.setTraitement(horraireSpecifique.getTraitement());
            horraireSpecifique1.setTypeHoraire(horraireSpecifique.isTypeHoraire());

            return horraireSpecifiqueRepository.save(horraireSpecifique1);
        }
        return null;
    }

    @Override
    public void delete(Long aLong) {
        horraireSpecifiqueRepository.deleteById(aLong);
    }

    @Override
    public List<HorraireSpecifique> findAll() {
        return horraireSpecifiqueRepository.findAll();
    }

    @Override
    public HorraireSpecifique findById(Long aLong) {
        return horraireSpecifiqueRepository.findById(aLong).get();
    }


}
