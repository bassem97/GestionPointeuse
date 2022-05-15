package com.spring.gestionpointeuse.Controller;

import com.spring.gestionpointeuse.Entity.ProfilSalaire;
import com.spring.gestionpointeuse.Service.ProfilSalaire.ProfilSalaireServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des profil Salaire")
@RequestMapping("/profilSalaire/")
public class ProfilSalaireController {
    @Autowired
    private ProfilSalaireServiceImpl profilSalaireService;

    @ApiOperation(value = "Lister tous les profil Salaire")
    @GetMapping("list")
    public List<ProfilSalaire> findAll() {
        return profilSalaireService.findAll();
    }

    @ApiOperation(value = "Ajouter profil Salaire")
    @PostMapping("add")
    public ProfilSalaire add(@RequestBody ProfilSalaire profilSalaire) {
        return profilSalaireService.add(profilSalaire);
    }

    @ApiOperation(value = "Modifier profil Salaire")
    @PutMapping("update/{id}")
    public ProfilSalaire update(@RequestBody ProfilSalaire profilSalaire, @PathVariable("id") Long id) {
        return profilSalaireService.update(profilSalaire, id);
    }

    @ApiOperation(value = "Supprimmer profil Salaire")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        profilSalaireService.delete(id);
    }


    @ApiOperation(value = "Find profilSalaire by provided id")
    @GetMapping("findById/{id}")
    public ProfilSalaire findById(@PathVariable("id") Long id) {
        return profilSalaireService.findById(id);
    }
}
