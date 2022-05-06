package com.spring.gestionpointeuse.Config.seeder;


import com.spring.gestionpointeuse.Entity.Company;
import com.spring.gestionpointeuse.Entity.Role;
import com.spring.gestionpointeuse.Repository.CompanyRepository;
import com.spring.gestionpointeuse.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanySeeder {

    @Autowired
    private CompanyRepository companyRepository;
    public Company company1 = new Company("company 1");

    public Company company2 = new Company("company 2");


    public void seed(){
        if(companyRepository.findAll().isEmpty()){
            companyRepository.save(company1);
            companyRepository.save(company2);
        }
    }

}
