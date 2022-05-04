package com.spring.gestionpointeuse.Controller;

import com.spring.gestionpointeuse.Entity.Usager;
import com.spring.gestionpointeuse.Service.Usager.UsagerServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des usagers")
@RequestMapping("/usager/")
public class UsagerController {
    @Autowired
    private UsagerServiceImpl usagerService;

    @ApiOperation(value = "Lister tous les usagers")
    @GetMapping("list")
    public List<Usager> findAll() {
        return usagerService.findAll();
    }

    @ApiOperation(value = "Ajouter usager")
    @PostMapping("add")
    public Usager add(@RequestBody Usager usager) {
        return usagerService.add(usager);
    }

    @ApiOperation(value = "Modifier usager")
    @PutMapping("update/{id}")
    public Usager update(@RequestBody Usager usager, @PathVariable("id") Long id) {
        return usagerService.update(usager, id);
    }

    @ApiOperation(value = "Supprimmer usager")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        usagerService.delete(id);
    }


    @ApiOperation(value = "Find usager by provided id")
    @GetMapping("findById/{id}")
    public Usager findById(@PathVariable("id") Long id) {
        return usagerService.findById(id);
    }
}
