package com.spring.gestionpointeuse.Controller;

import com.spring.gestionpointeuse.Entity.ProfilCalendaire;
import com.spring.gestionpointeuse.Service.ProfilCalendaire.ProfilCalendaireServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des profil Calendaire")
@RequestMapping("/profilCalendaire/")
public class ProfilCalendaireController {
    @Autowired
    private ProfilCalendaireServiceImpl profilCalendaireService;

    @ApiOperation(value = "Lister tous les profilCalendaire")
    @GetMapping("list")
    public List<ProfilCalendaire> findAll() {
        return profilCalendaireService.findAll();
    }

    @ApiOperation(value = "Ajouter profilCalendaire")
    @PostMapping("add")
    public ProfilCalendaire add(@RequestBody ProfilCalendaire profilCalendaire) {
        return profilCalendaireService.add(profilCalendaire);
    }

    @ApiOperation(value = "Modifier profilCalendaire")
    @PutMapping("update/{id}")
    public ProfilCalendaire update(@RequestBody ProfilCalendaire profilCalendaire, @PathVariable("id") Long id) {
        return profilCalendaireService.update(profilCalendaire, id);
    }

    @ApiOperation(value = "Supprimmer profilCalendaire")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        profilCalendaireService.delete(id);
    }


    @ApiOperation(value = "Find profilCalendaire by provided id")
    @GetMapping("findById/{id}")
    public ProfilCalendaire findById(@PathVariable("id") Long id) {
        return profilCalendaireService.findById(id);
    }
}
