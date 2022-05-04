package com.spring.gestionpointeuse.Controller;

import com.spring.gestionpointeuse.Entity.Fonctionalitie;
import com.spring.gestionpointeuse.Service.Fonctionalitie.FonctionalitieServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des fonctionalités")
@RequestMapping("/fonctionalitie/")
public class FonctionalitieController {
    @Autowired
    private FonctionalitieServiceImpl fonctionalitieService;

    @ApiOperation(value = "Lister tous les fonctionalités")
    @GetMapping("list")
    public List<Fonctionalitie> findAll() {
        return fonctionalitieService.findAll();
    }

    @ApiOperation(value = "Ajouter fonctionalité")
    @PostMapping("add")
    public Fonctionalitie add(@RequestBody Fonctionalitie fonctionalitie) {
        return fonctionalitieService.add(fonctionalitie);
    }

    @ApiOperation(value = "Modifier fonctionalité")
    @PutMapping("update/{id}")
    public Fonctionalitie update(@RequestBody Fonctionalitie fonctionalitie, @PathVariable("id") Long id) {
        return fonctionalitieService.update(fonctionalitie, id);
    }

    @ApiOperation(value = "Supprimmer fonctionalité")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        fonctionalitieService.delete(id);
    }


    @ApiOperation(value = "Find fonctionalitie by provided id")
    @GetMapping("findById/{id}")
    public Fonctionalitie findById(@PathVariable("id") Long id) {
        return fonctionalitieService.findById(id);
    }
}
