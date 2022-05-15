package com.spring.gestionpointeuse.Controller;

import com.spring.gestionpointeuse.Entity.HorraireSpecifique;
import com.spring.gestionpointeuse.Service.HorraireSpecifique.HorraireSpecifiqueServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des horraire Specifique")
@RequestMapping("/horraireSpecifique/")
public class HorraireSpecifiqueController {
    @Autowired
    private HorraireSpecifiqueServiceImpl horraireSpecifiqueService;

    @ApiOperation(value = "Lister tous les horraire Specifique")
    @GetMapping("list")
    public List<HorraireSpecifique> findAll() {
        return horraireSpecifiqueService.findAll();
    }

    @ApiOperation(value = "Ajouter horraire Specifique")
    @PostMapping("add")
    public HorraireSpecifique add(@RequestBody HorraireSpecifique horraireSpecifique) {
        return horraireSpecifiqueService.add(horraireSpecifique);
    }

    @ApiOperation(value = "Modifier horraire Specifique")
    @PutMapping("update/{id}")
    public HorraireSpecifique update(@RequestBody HorraireSpecifique horraireSpecifique, @PathVariable("id") Long id) {
        return horraireSpecifiqueService.update(horraireSpecifique, id);
    }

    @ApiOperation(value = "Supprimmer horraire Specifique")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        horraireSpecifiqueService.delete(id);
    }


    @ApiOperation(value = "Find horraire Specifique by provided id")
    @GetMapping("findById/{id}")
    public HorraireSpecifique findById(@PathVariable("id") Long id) {
        return horraireSpecifiqueService.findById(id);
    }
}
