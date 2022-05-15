package com.spring.gestionpointeuse.Controller;

import com.spring.gestionpointeuse.Entity.Pointeuse;
import com.spring.gestionpointeuse.Service.Pointeuse.PointeuseServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des pointeuse")
@RequestMapping("/pointeuse/")
public class PointeuseController {
    @Autowired
    private PointeuseServiceImpl pointeuseService;

    @ApiOperation(value = "Lister tous les pointeuse")
    @GetMapping("list")
    public List<Pointeuse> findAll() {
        return pointeuseService.findAll();
    }

    @ApiOperation(value = "Ajouter pointeuse")
    @PostMapping("add")
    public Pointeuse add(@RequestBody Pointeuse pointeuse) {
        return pointeuseService.add(pointeuse);
    }

    @ApiOperation(value = "Modifier pointeuse")
    @PutMapping("update/{id}")
    public Pointeuse update(@RequestBody Pointeuse pointeuse, @PathVariable("id") Long id) {
        return pointeuseService.update(pointeuse, id);
    }

    @ApiOperation(value = "Supprimmer pointeuse")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        pointeuseService.delete(id);
    }


    @ApiOperation(value = "Find pointeuse by provided id")
    @GetMapping("findById/{id}")
    public Pointeuse findById(@PathVariable("id") Long id) {
        return pointeuseService.findById(id);
    }
}
