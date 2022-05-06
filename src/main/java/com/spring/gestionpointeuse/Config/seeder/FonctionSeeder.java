package com.spring.gestionpointeuse.Config.seeder;


import com.spring.gestionpointeuse.Entity.Company;
import com.spring.gestionpointeuse.Entity.Fonction;
import com.spring.gestionpointeuse.Repository.CompanyRepository;
import com.spring.gestionpointeuse.Repository.FonctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FonctionSeeder {

    @Autowired
    private FonctionRepository fonctionRepository;

    public Fonction fonction1 = new Fonction("fonction 1");
    public Fonction fonction2 = new Fonction("fonction 2");



    public void seed(){
        if(fonctionRepository.findAll().isEmpty()){
            fonctionRepository.save(fonction1);
            fonctionRepository.save(fonction2);
        }
    }

}
