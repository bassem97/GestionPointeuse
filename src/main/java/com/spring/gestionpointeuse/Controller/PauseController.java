package com.spring.gestionpointeuse.Controller;

import com.spring.gestionpointeuse.Entity.Pause;
import com.spring.gestionpointeuse.Service.Pause.PauseServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des pauses")
@RequestMapping("/pause/")
public class PauseController {
    @Autowired
    private PauseServiceImpl pauseService;

    @ApiOperation(value = "Lister tous les pause")
    @GetMapping("list")
    public List<Pause> findAll() {
        return pauseService.findAll();
    }

    @ApiOperation(value = "Ajouter pause")
    @PostMapping("add")
    public Pause add(@RequestBody Pause pause) {
        return pauseService.add(pause);
    }

    @ApiOperation(value = "Modifier pause")
    @PutMapping("update/{id}")
    public Pause update(@RequestBody Pause pause, @PathVariable("id") Long id) {
        return pauseService.update(pause, id);
    }

    @ApiOperation(value = "Supprimmer pause")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        pauseService.delete(id);
    }


    @ApiOperation(value = "Find pause by provided id")
    @GetMapping("findById/{id}")
    public Pause findById(@PathVariable("id") Long id) {
        return pauseService.findById(id);
    }
}
