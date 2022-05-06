package com.spring.gestionpointeuse.Controller;

import com.spring.gestionpointeuse.Entity.Role;
import com.spring.gestionpointeuse.Service.Role.RoleServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des roles")
@RequestMapping("/role/")
public class RoleController {
    @Autowired
    private RoleServiceImpl roleService;

    @ApiOperation(value = "Lister tous les roles")
    @GetMapping("list")
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @ApiOperation(value = "Ajouter role")
    @PostMapping("add")
    public Role add(@RequestBody Role role) {
        return roleService.add(role);
    }

    @ApiOperation(value = "Modifier role")
    @PutMapping("update/{id}")
    public Role update(@RequestBody Role role, @PathVariable("id") Long id) {
        return roleService.update(role, id);
    }

    @ApiOperation(value = "Supprimmer role")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        roleService.delete(id);
    }

    @ApiOperation(value = "Find role by provided id")
    @GetMapping("findById/{id}")
    public Role findById(@PathVariable("id") Long id) {
        return roleService.findById(id);
    }
}
