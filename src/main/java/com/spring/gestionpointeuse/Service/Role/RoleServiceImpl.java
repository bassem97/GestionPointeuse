package com.spring.gestionpointeuse.Service.Role;

import com.spring.gestionpointeuse.Entity.Role;
import com.spring.gestionpointeuse.Repository.RoleRepository;
import com.spring.gestionpointeuse.Service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements IRoleService, ICrudService<Role,Long> {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role add(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Role role, Long aLong) {
        if (roleRepository.findById(aLong).isPresent()) {
            Role role1 = roleRepository.findById(aLong).get();
            role1.setRole(role.getRole());
            role1.setUsagers(role.getUsagers());

            return roleRepository.save(role1);
        }
        return null;
    }

    @Override
    public void delete(Long aLong) {
        roleRepository.deleteById(aLong);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Long aLong) {
        return roleRepository.findById(aLong).get();
    }


}
