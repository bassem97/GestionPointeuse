package com.spring.gestionpointeuse.Config.seeder;

import com.spring.gestionpointeuse.Ennum.SEXE;
import com.spring.gestionpointeuse.Entity.Usager;
import com.spring.gestionpointeuse.Service.Usager.UsagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Calendar;

@Component
public class UsagerSeeder {

    @Autowired
    RoleSeeder roleSeeder;
    @Autowired
    CompanySeeder companySeeder;



    @Autowired
    private UsagerServiceImpl usagerService;

    public Usager usager1 ;
    public Usager usager2;

    public void seed() {

        if(usagerService.findAll().isEmpty()){
            usager1 = new Usager("bassem", "jadoui", "bassem97","bassemjadoui1996@gmail.com","123456", SEXE.homme, LocalDate.of(1997,Calendar.MAY,20),roleSeeder.admin,companySeeder.company1);
            usager2 =  new Usager("taher", "Hosseyni", "taher2022","taherhoseyni@gmail.com","123456", SEXE.homme, LocalDate.of(1997,Calendar.MAY,20),roleSeeder.client,companySeeder.company2);
            usagerService.add(usager1);
            usagerService.add(usager2);
        }

    }
}
