package com.spring.gestionpointeuse.Config.seeder;

import org.hibernate.type.ByteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeedByOrder {

    @Autowired
    private RoleSeeder roleSeeder;
    @Autowired
    private CompanySeeder companySeeder;
    @Autowired
    private FonctionSeeder fonctionSeeder;



    public void init() throws Exception {

        roleSeeder.seed();
        companySeeder.seed();
        fonctionSeeder.seed();

    }

}
