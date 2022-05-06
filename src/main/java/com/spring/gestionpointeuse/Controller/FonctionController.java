package com.spring.gestionpointeuse.Controller;

import com.spring.gestionpointeuse.Entity.Fonction;
import com.spring.gestionpointeuse.Service.Fonction.FonctionServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des fonction")
@RequestMapping("/fonction/")
public class FonctionController {
    @Autowired
    private FonctionServiceImpl fonctionService;

    @ApiOperation(value = "Lister tous les fonctions")
    @GetMapping("list")
    public List<Fonction> findAll() {
        return fonctionService.findAll();
    }

    @ApiOperation(value = "Ajouter fonction")
    @PostMapping("add")
    public Fonction add(@RequestBody Fonction fonction) {
        return fonctionService.add(fonction);
    }

    @ApiOperation(value = "Modifier fonction")
    @PutMapping("update/{id}")
    public Fonction update(@RequestBody Fonction fonction, @PathVariable("id") Long id) {
        return fonctionService.update(fonction, id);
    }

    @ApiOperation(value = "Supprimmer fonction")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        fonctionService.delete(id);
    }


    @ApiOperation(value = "Find fonction by provided id")
    @GetMapping("findById/{id}")
    public Fonction findById(@PathVariable("id") Long id) {
        return fonctionService.findById(id);
    }
}
