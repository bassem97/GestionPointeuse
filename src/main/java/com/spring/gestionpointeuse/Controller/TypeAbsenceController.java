package com.spring.gestionpointeuse.Controller;

import com.spring.gestionpointeuse.Entity.TypeAbsence;
import com.spring.gestionpointeuse.Service.TypeAbsence.TypeAbsenceServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des type Absence")
@RequestMapping("/typeAbsence/")
public class TypeAbsenceController {
    @Autowired
    private TypeAbsenceServiceImpl typeAbsenceService;

    @ApiOperation(value = "Lister tous les type Absence")
    @GetMapping("list")
    public List<TypeAbsence> findAll() {
        return typeAbsenceService.findAll();
    }

    @ApiOperation(value = "Ajouter type Absence")
    @PostMapping("add")
    public TypeAbsence add(@RequestBody TypeAbsence typeAbsence) {
        return typeAbsenceService.add(typeAbsence);
    }

    @ApiOperation(value = "Modifier type Absence")
    @PutMapping("update/{id}")
    public TypeAbsence update(@RequestBody TypeAbsence typeAbsence, @PathVariable("id") Long id) {
        return typeAbsenceService.update(typeAbsence, id);
    }

    @ApiOperation(value = "Supprimmer type Absence")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        typeAbsenceService.delete(id);
    }


    @ApiOperation(value = "Find type Absence by provided id")
    @GetMapping("findById/{id}")
    public TypeAbsence findById(@PathVariable("id") Long id) {
        return typeAbsenceService.findById(id);
    }
}
