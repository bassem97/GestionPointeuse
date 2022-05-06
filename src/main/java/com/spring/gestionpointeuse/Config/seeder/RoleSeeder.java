package com.spring.gestionpointeuse.Config.seeder;


import com.spring.gestionpointeuse.Entity.Role;
import com.spring.gestionpointeuse.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleSeeder {

    @Autowired
    private RoleRepository roleRepository;
    public Role admin = new Role("ADMIN");
    public Role client = new Role("CLIENT");

    public void seed(){
        if(roleRepository.findAll().isEmpty()){
            roleRepository.save(admin);
            roleRepository.save(client);
        }
    }

}
