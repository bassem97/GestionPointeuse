package com.spring.gestionpointeuse.Controller;

import com.spring.gestionpointeuse.Entity.Absence;
import com.spring.gestionpointeuse.Service.Absence.AbsenceServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des absence")
@RequestMapping("/absence/")
public class AbsenceController {
    @Autowired
    private AbsenceServiceImpl absenceService;

    @ApiOperation(value = "Lister tous les absence")
    @GetMapping("list")
    public List<Absence> findAll() {
        return absenceService.findAll();
    }

    @ApiOperation(value = "Ajouter absence")
    @PostMapping("add")
    public Absence add(@RequestBody Absence absence) {
        return absenceService.add(absence);
    }

    @ApiOperation(value = "Modifier absence")
    @PutMapping("update/{id}")
    public Absence update(@RequestBody Absence absence, @PathVariable("id") Long id) {
        return absenceService.update(absence, id);
    }

    @ApiOperation(value = "Supprimmer absence")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        absenceService.delete(id);
    }


    @ApiOperation(value = "Find absence by provided id")
    @GetMapping("findById/{id}")
    public Absence findById(@PathVariable("id") Long id) {
        return absenceService.findById(id);
    }
}
