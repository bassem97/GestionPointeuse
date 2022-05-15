package com.spring.gestionpointeuse.Controller;

import com.spring.gestionpointeuse.Entity.SalaireCalendaire;
import com.spring.gestionpointeuse.Service.SalaireCalendaire.SalaireCalendaireServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des salaire Calendaire")
@RequestMapping("/salaireCalendaire/")
public class SalaireCalendaireController {
    @Autowired
    private SalaireCalendaireServiceImpl salaireCalendaireService;

    @ApiOperation(value = "Lister tous les salaire Calendaire")
    @GetMapping("list")
    public List<SalaireCalendaire> findAll() {
        return salaireCalendaireService.findAll();
    }

    @ApiOperation(value = "Ajouter salaire Calendaire")
    @PostMapping("add")
    public SalaireCalendaire add(@RequestBody SalaireCalendaire salaireCalendaire) {
        return salaireCalendaireService.add(salaireCalendaire);
    }

    @ApiOperation(value = "Modifier salaire Calendaire")
    @PutMapping("update/{id}")
    public SalaireCalendaire update(@RequestBody SalaireCalendaire salaireCalendaire, @PathVariable("id") Long id) {
        return salaireCalendaireService.update(salaireCalendaire, id);
    }

    @ApiOperation(value = "Supprimmer salaire Calendaire")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        salaireCalendaireService.delete(id);
    }


    @ApiOperation(value = "Find salaireCalendaire by provided id")
    @GetMapping("findById/{id}")
    public SalaireCalendaire findById(@PathVariable("id") Long id) {
        return salaireCalendaireService.findById(id);
    }
}
