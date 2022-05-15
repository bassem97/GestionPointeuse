package com.spring.gestionpointeuse.Config.seeder;


import com.spring.gestionpointeuse.Entity.Company;
import com.spring.gestionpointeuse.Repository.CompanyRepository;
import com.vaadin.exampledata.DataType;
import com.vaadin.exampledata.ExampleDataGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Component
@Slf4j
public class CompanySeeder {

    @Autowired
    private CompanyRepository companyRepository;
    public Company company1;

    public Company company2;


    public void seed() {
        if(companyRepository.findAll().isEmpty()) {
            log.info("Generating demo data...");

            var generator = new ExampleDataGenerator<>(Company.class, LocalDateTime.now());
            generator.setData(Company::setDesignation, DataType.COMPANY_NAME);
            StopWatch stopWatch = new StopWatch(); stopWatch.start();
            List<Company> companies = generator.create(50, new Random().nextInt());

            companyRepository.saveAll(companies);

            stopWatch.stop();
            log.info("Demo data generated in " + stopWatch.getTime() + "ms.");
        }
    }

}
