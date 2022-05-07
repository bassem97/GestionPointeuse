package com.spring.gestionpointeuse.Config.seeder;


import com.spring.gestionpointeuse.Entity.Fonction;
import com.spring.gestionpointeuse.Entity.Fonctionalitie;
import com.spring.gestionpointeuse.Repository.FonctionRepository;
import com.spring.gestionpointeuse.Repository.FonctionalitieRepository;
import com.spring.gestionpointeuse.Service.Fonctionalitie.FonctionalitieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FonctionaliteSeeder {

    @Autowired
    private UsagerSeeder usagerSeeder;

    @Autowired
    private FonctionSeeder fonctionSeeder;

    @Autowired
    private FonctionalitieServiceImpl fonctionalitieService;

    public Fonctionalitie fonctionalitie1;
    public Fonctionalitie fonctionalitie2;



    public void seed(){
        if(fonctionalitieService.findAll().isEmpty()){
            fonctionalitie1 = new Fonctionalitie(fonctionSeeder.fonction1,true,true,true,true,usagerSeeder.usager1);
            fonctionalitie2 = new Fonctionalitie(fonctionSeeder.fonction2,true,false,false,false,usagerSeeder.usager2);
            fonctionalitieService.add(fonctionalitie1);
            fonctionalitieService.add(fonctionalitie2);
        }
    }

}
