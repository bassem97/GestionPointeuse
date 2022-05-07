package com.spring.gestionpointeuse.Config.seeder;

import com.spring.gestionpointeuse.Entity.Details;
import com.spring.gestionpointeuse.Service.Details.DetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

@Component
public class DetailSeeder {

    @Autowired
    private UsagerSeeder usagerSeeder;

    @Autowired
    private DetailsServiceImpl detailsService;

    public Details details1 ;
    public Details details2 ;

    public void seed() {

        if(detailsService.findAll().isEmpty()){
            details1 = new Details(usagerSeeder.usager1,
                    "ariena","www.website.com","www.github.com",
                    "www.linkedin.com","+21655135774",
                    "+21670111222","Etudiant");

            details2 = new Details(usagerSeeder.usager2,
                    "soukra","www.website2.com","www.github2.com",
                    "www.linkedin2.com","+21655135777",
                    "+21670111555","Professeur");

            detailsService.add(details1);
            detailsService.add(details2);
        }



    }

}
