package com.spring.gestionpointeuse.Service.Details;

import com.spring.gestionpointeuse.Entity.Details;
import com.spring.gestionpointeuse.Repository.DetailsRepository;
import com.spring.gestionpointeuse.Service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailsServiceImpl implements IDetailsService, ICrudService<Details,Long> {

    @Autowired
    private DetailsRepository detailsRepository;


    @Override
    public Details add(Details details) {
        return detailsRepository.save(details);
    }

    @Override
    public Details update(Details details, Long aLong) {
        if (detailsRepository.findById(aLong).isPresent()) {
            Details details1 = detailsRepository.findById(aLong).get();
            details1.setAdresse(details.getAdresse());
            details1.setGithub(details.getGithub());
            details1.setMobile(details.getMobile());
            details1.setPhone(details.getPhone());
            details1.setProfession(details.getProfession());
            details1.setWebstite(details.getWebstite());
            details1.setUsager(details.getUsager());

            return detailsRepository.save(details1);
        }
        return null;
    }

    @Override
    public void delete(Long aLong) {
        detailsRepository.deleteById(aLong);
    }

    @Override
    public List<Details> findAll() {
        return detailsRepository.findAll();
    }

    @Override
    public Details findById(Long aLong) {
        return detailsRepository.findById(aLong).get();
    }

}
