package com.spring.gestionpointeuse.Service.Pointeuse;

import com.spring.gestionpointeuse.Entity.Pointeuse;
import com.spring.gestionpointeuse.Repository.PointeuseRepository;
import com.spring.gestionpointeuse.Service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PointeuseServiceImpl implements IPointeuseService, ICrudService<Pointeuse,Long> {

    @Autowired
    private PointeuseRepository pointeuseRepository;

    @Override
    public Pointeuse add(Pointeuse pointeuse) {
        return pointeuseRepository.save(pointeuse);
    }

    @Override
    public Pointeuse update(Pointeuse pointeuse, Long aLong) {
        if (pointeuseRepository.findById(aLong).isPresent()) {
            Pointeuse pointeuse1 = pointeuseRepository.findById(aLong).get();
            pointeuse1.setDesignation(pointeuse.getDesignation());
            pointeuse1.setType(pointeuse.getType());
            pointeuse1.setPort(pointeuse.getPort());
            pointeuse1.setAdresseIp(pointeuse.getAdresseIp());
            pointeuse1.setEtat(pointeuse.isEtat());
            pointeuse1.setConnexion(pointeuse.isConnexion());
            pointeuse1.setPrincipale(pointeuse.isPrincipale());

            return pointeuseRepository.save(pointeuse1);
        }
        return null;
    }

    @Override
    public void delete(Long aLong) {
        pointeuseRepository.deleteById(aLong);
    }

    @Override
    public List<Pointeuse> findAll() {
        return pointeuseRepository.findAll();
    }

    @Override
    public Pointeuse findById(Long aLong) {
        return pointeuseRepository.findById(aLong).get();
    }


}
