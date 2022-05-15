package com.spring.gestionpointeuse.Config.seeder;

import com.spring.gestionpointeuse.Entity.ProfilCalendaire;
import org.hibernate.type.ByteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springfox.documentation.annotations.ApiIgnore;

@Component
public class SeedByOrder {

    @Autowired
    private RoleSeeder roleSeeder;
    @Autowired
    private CompanySeeder companySeeder;
    @Autowired
    private FonctionSeeder fonctionSeeder;

    @Autowired
    private DetailSeeder detailSeeder;

    @Autowired
    private UsagerSeeder usagerSeeder;

    @Autowired
    private FonctionaliteSeeder fonctionalitieSeeder;

    @Autowired
    private ProfilCalendaireSeeder profilCalendaireSeeder;


    public void init() throws Exception {

        roleSeeder.seed();
        companySeeder.seed();
        fonctionSeeder.seed();
        usagerSeeder.seed();
        fonctionalitieSeeder.seed();
        detailSeeder.seed();
        profilCalendaireSeeder.seed();

    }

}
