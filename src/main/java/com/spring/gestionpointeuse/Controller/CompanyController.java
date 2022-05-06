package com.spring.gestionpointeuse.Controller;

import com.spring.gestionpointeuse.Entity.Company;
import com.spring.gestionpointeuse.Service.Company.CompanyServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des company")
@RequestMapping("/company/")
public class CompanyController {
    @Autowired
    private CompanyServiceImpl companyService;

    @ApiOperation(value = "Lister tous les company")
    @GetMapping("list")
    public List<Company> findAll() {
        return companyService.findAll();
    }

    @ApiOperation(value = "Ajouter company")
    @PostMapping("add")
    public Company add(@RequestBody Company company) {
        return companyService.add(company);
    }

    @ApiOperation(value = "Modifier company")
    @PutMapping("update/{id}")
    public Company update(@RequestBody Company company, @PathVariable("id") Long id) {
        return companyService.update(company, id);
    }

    @ApiOperation(value = "Supprimmer company")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        companyService.delete(id);
    }


    @ApiOperation(value = "Find company by provided id")
    @GetMapping("findById/{id}")
    public Company findById(@PathVariable("id") Long id) {
        return companyService.findById(id);
    }
}
