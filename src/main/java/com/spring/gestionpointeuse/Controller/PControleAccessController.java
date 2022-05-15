package com.spring.gestionpointeuse.Controller;

import com.spring.gestionpointeuse.Entity.PControleAccess;
import com.spring.gestionpointeuse.Service.PControleAccess.PControleAccessServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des pControle Access")
@RequestMapping("/pControleAccess/")
public class PControleAccessController {
    @Autowired
    private PControleAccessServiceImpl pControleAccessService;

    @ApiOperation(value = "Lister tous les pControle Access")
    @GetMapping("list")
    public List<PControleAccess> findAll() {
        return pControleAccessService.findAll();
    }

    @ApiOperation(value = "Ajouter pControle Access")
    @PostMapping("add")
    public PControleAccess add(@RequestBody PControleAccess pControleAccess) {
        return pControleAccessService.add(pControleAccess);
    }

    @ApiOperation(value = "Modifier pControle Access")
    @PutMapping("update/{id}")
    public PControleAccess update(@RequestBody PControleAccess pControleAccess, @PathVariable("id") Long id) {
        return pControleAccessService.update(pControleAccess, id);
    }

    @ApiOperation(value = "Supprimmer pControle Access")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        pControleAccessService.delete(id);
    }


    @ApiOperation(value = "Find pControleAccess by provided id")
    @GetMapping("findById/{id}")
    public PControleAccess findById(@PathVariable("id") Long id) {
        return pControleAccessService.findById(id);
    }
}
