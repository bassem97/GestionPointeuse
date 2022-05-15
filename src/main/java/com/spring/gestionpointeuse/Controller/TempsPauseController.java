package com.spring.gestionpointeuse.Controller;

import com.spring.gestionpointeuse.Entity.TempsPause;
import com.spring.gestionpointeuse.Service.TempsPause.TempsPauseServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des Temps Pauses")
@RequestMapping("/tempspause/")
public class TempsPauseController {
    @Autowired
    private TempsPauseServiceImpl tempsPauseService;

    @ApiOperation(value = "Lister tous les Temps Pause")
    @GetMapping("list")
    public List<TempsPause> findAll() {
        return tempsPauseService.findAll();
    }

    @ApiOperation(value = "Ajouter Temps Pause")
    @PostMapping("add")
    public TempsPause add(@RequestBody TempsPause tempsPause) {
        return tempsPauseService.add(tempsPause);
    }

    @ApiOperation(value = "Modifier temps Pause")
    @PutMapping("update/{id}")
    public TempsPause update(@RequestBody TempsPause tempsPause, @PathVariable("id") Long id) {
        return tempsPauseService.update(tempsPause, id);
    }

    @ApiOperation(value = "Supprimmer tempsTempsPause")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        tempsPauseService.delete(id);
    }


    @ApiOperation(value = "Find tempsTempsPause by provided id")
    @GetMapping("findById/{id}")
    public TempsPause findById(@PathVariable("id") Long id) {
        return tempsPauseService.findById(id);
    }
}
