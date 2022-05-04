package com.spring.gestionpointeuse.Service.Usager;

import com.spring.gestionpointeuse.Entity.Usager;
import com.spring.gestionpointeuse.Repository.UsagerRepository;
import com.spring.gestionpointeuse.Service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsagerServiceImpl implements IUsagerService , ICrudService<Usager,Long> {

    @Autowired
    private UsagerRepository usagerRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public Usager add(Usager usager) {
        usager.setPassword(bcryptEncoder.encode(usager.getPassword()));
        return usagerRepository.save(usager);
    }

    @Override
    public Usager update(Usager usager, Long aLong) {
        if (usagerRepository.findById(aLong).isPresent()) {
            Usager usager1 = usagerRepository.findById(aLong).get();
            usager1.setNom(usager.getNom());
            usager1.setPrenom(usager.getPrenom());
            usager1.setUsername(usager.getUsername());
            usager1.setEmail(usager.getEmail());
            usager1.setPassword(bcryptEncoder.encode(usager.getPassword()));
            usager1.setProffession(usager.getProffession());
            usager1.setEmpreinte(usager.getEmpreinte());
            usager1.setBadge(usager.getBadge());
            usager1.setNumero(usager.getNumero());
            usager1.setSexe(usager.getSexe());
            usager1.setDateNaissance(usager.getDateNaissance());

            return usagerRepository.save(usager1);
        }
        return null;
    }

    @Override
    public void delete(Long aLong) {
        usagerRepository.deleteById(aLong);
    }

    @Override
    public List<Usager> findAll() {
        return usagerRepository.findAll();
    }

    @Override
    public Usager findById(Long aLong) {
        return usagerRepository.findById(aLong).get();
    }
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
