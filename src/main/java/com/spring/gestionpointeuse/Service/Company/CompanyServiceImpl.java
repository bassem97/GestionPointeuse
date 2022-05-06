package com.spring.gestionpointeuse.Service.Company;

import com.spring.gestionpointeuse.Entity.Company;
import com.spring.gestionpointeuse.Repository.CompanyRepository;
import com.spring.gestionpointeuse.Service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyServiceImpl implements ICompanyService, ICrudService<Company,Long> {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company add(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company update(Company company, Long aLong) {
        if (companyRepository.findById(aLong).isPresent()) {
            Company company1 = companyRepository.findById(aLong).get();
            company1.setDesignation(company.getDesignation());
            company1.setUsagers(company.getUsagers());

            return companyRepository.save(company1);
        }
        return null;
    }

    @Override
    public void delete(Long aLong) {
        companyRepository.deleteById(aLong);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findById(Long aLong) {
        return companyRepository.findById(aLong).get();
    }


}
