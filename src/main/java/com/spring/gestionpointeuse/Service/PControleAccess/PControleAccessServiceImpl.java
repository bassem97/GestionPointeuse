package com.spring.gestionpointeuse.Service.PControleAccess;

import com.spring.gestionpointeuse.Entity.PControleAccess;
import com.spring.gestionpointeuse.Entity.PControleAccess;
import com.spring.gestionpointeuse.Repository.PControleAccessRepository;
import com.spring.gestionpointeuse.Service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PControleAccessServiceImpl implements IPControleAccessService, ICrudService<PControleAccess,Long> {

    @Autowired
    private PControleAccessRepository pControleAccessRepository;

    @Override
    public PControleAccess add(PControleAccess pControleAccess) {
        return pControleAccessRepository.save(pControleAccess);
    }

    @Override
    public PControleAccess update(PControleAccess pControleAccess, Long aLong) {
        if (pControleAccessRepository.findById(aLong).isPresent()) {
            PControleAccess pControleAccess1 = pControleAccessRepository.findById(aLong).get();
            pControleAccess1.setDesignation(pControleAccess.getDesignation());
            pControleAccess1.setUsagers(pControleAccess.getUsagers());

            return pControleAccessRepository.save(pControleAccess1);
        }
        return null;
    }

    @Override
    public void delete(Long aLong) {
        pControleAccessRepository.deleteById(aLong);
    }

    @Override
    public List<PControleAccess> findAll() {
        return pControleAccessRepository.findAll();
    }

    @Override
    public PControleAccess findById(Long aLong) {
        return pControleAccessRepository.findById(aLong).get();
    }


}
