package com.spring.gestionpointeuse.Controller;

import com.spring.gestionpointeuse.Entity.Evenement;
import com.spring.gestionpointeuse.Service.Evenement.EvenementServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des evenement")
@RequestMapping("/evenement/")
public class EvenementController {
    @Autowired
    private EvenementServiceImpl evenementService;

    @ApiOperation(value = "Lister tous les evenement")
    @GetMapping("list")
    public List<Evenement> findAll() {
        return evenementService.findAll();
    }

    @ApiOperation(value = "Ajouter evenement")
    @PostMapping("add")
    public Evenement add(@RequestBody Evenement evenement) {
        return evenementService.add(evenement);
    }

    @ApiOperation(value = "Modifier evenement")
    @PutMapping("update/{id}")
    public Evenement update(@RequestBody Evenement evenement, @PathVariable("id") Long id) {
        return evenementService.update(evenement, id);
    }

    @ApiOperation(value = "Supprimmer evenement")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        evenementService.delete(id);
    }


    @ApiOperation(value = "Find evenement by provided id")
    @GetMapping("findById/{id}")
    public Evenement findById(@PathVariable("id") Long id) {
        return evenementService.findById(id);
    }
}
