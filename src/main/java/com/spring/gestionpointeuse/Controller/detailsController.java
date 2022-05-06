package com.spring.gestionpointeuse.Controller;

import com.spring.gestionpointeuse.Entity.Details;
import com.spring.gestionpointeuse.Service.Details.DetailsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des details")
@RequestMapping("/details/")
public class detailsController {
    @Autowired
    private DetailsServiceImpl detailsService;

    @ApiOperation(value = "Lister tous les details")
    @GetMapping("list")
    public List<Details> findAll() {
        return detailsService.findAll();
    }

    @ApiOperation(value = "Ajouter details")
    @PostMapping("add")
    public Details add(@RequestBody Details details) {
        return detailsService.add(details);
    }

    @ApiOperation(value = "Modifier details")
    @PutMapping("update/{id}")
    public Details update(@RequestBody Details details, @PathVariable("id") Long id) {
        return detailsService.update(details, id);
    }

    @ApiOperation(value = "Supprimmer details")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        detailsService.delete(id);
    }


    @ApiOperation(value = "Find details by provided id")
    @GetMapping("findById/{id}")
    public Details findById(@PathVariable("id") Long id) {
        return detailsService.findById(id);
    }
}
