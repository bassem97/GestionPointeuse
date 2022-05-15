package com.spring.gestionpointeuse.Service.Absence;

import com.spring.gestionpointeuse.Entity.Absence;
import com.spring.gestionpointeuse.Repository.AbsenceRepository;
import com.spring.gestionpointeuse.Service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AbsenceServiceImpl implements IAbsenceService, ICrudService<Absence,Long> {

    @Autowired
    private AbsenceRepository absenceRepository;

    @Override
    public Absence add(Absence absence) {
        return absenceRepository.save(absence);
    }

    @Override
    public Absence update(Absence absence, Long aLong) {
        if (absenceRepository.findById(aLong).isPresent()) {
            Absence absence1 = absenceRepository.findById(aLong).get();
            absence1.setDesignation(absence.getDesignation());
            absence1.setDateDebut(absence.getDateDebut());
            absence1.setDateFin(absence.getDateFin());
            absence1.setTypeAbsence(absence.getTypeAbsence());
            absence1.setUsager(absence.getUsager());
        }
        return null;
    }

    @Override
    public void delete(Long aLong) {
        absenceRepository.deleteById(aLong);
    }

    @Override
    public List<Absence> findAll() {
        return absenceRepository.findAll();
    }

    @Override
    public Absence findById(Long aLong) {
        return absenceRepository.findById(aLong).get();
    }


}
