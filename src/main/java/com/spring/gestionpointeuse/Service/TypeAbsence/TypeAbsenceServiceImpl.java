package com.spring.gestionpointeuse.Service.TypeAbsence;

import com.spring.gestionpointeuse.Entity.TypeAbsence;
import com.spring.gestionpointeuse.Repository.TypeAbsenceRepository;
import com.spring.gestionpointeuse.Service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeAbsenceServiceImpl implements ITypeAbsenceService, ICrudService<TypeAbsence,Long> {

    @Autowired
    private TypeAbsenceRepository typeAbsenceRepository;

    @Override
    public TypeAbsence add(TypeAbsence typeAbsence) {
        return typeAbsenceRepository.save(typeAbsence);
    }

    @Override
    public TypeAbsence update(TypeAbsence typeAbsence, Long aLong) {
        if (typeAbsenceRepository.findById(aLong).isPresent()) {
            TypeAbsence typeAbsence1 = typeAbsenceRepository.findById(aLong).get();
            typeAbsence1.setDesignation(typeAbsence.getDesignation());
            typeAbsence1.setCompany(typeAbsence.getCompany());
            typeAbsence1.setCouleur(typeAbsence.getCouleur());
            typeAbsence1.setTypeContabilisation(typeAbsence.getTypeContabilisation());
            typeAbsence1.setTraiteAbsence(typeAbsence.getTraiteAbsence());

            return typeAbsenceRepository.save(typeAbsence1);
        }
        return null;
    }

    @Override
    public void delete(Long aLong) {
        typeAbsenceRepository.deleteById(aLong);
    }

    @Override
    public List<TypeAbsence> findAll() {
        return typeAbsenceRepository.findAll();
    }

    @Override
    public TypeAbsence findById(Long aLong) {
        return typeAbsenceRepository.findById(aLong).get();
    }


}
