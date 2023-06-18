package com.transportcompany.transportcompanyspring.controller;

import com.transportcompany.transportcompanyspring.entity.Company;
import com.transportcompany.transportcompanyspring.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/companies")
@AllArgsConstructor
public class CompanyController {
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        Company company1 = companyService.addCompany(company);
        return new ResponseEntity<>(company1, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Company> removeCompany(@PathVariable("id") long companyId) {
        Company deletedCompany = companyService.removeCompany(companyId);
        return new ResponseEntity<>(deletedCompany, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable("id") long companyId, @RequestBody Company company) {
        Company updatedCompany = companyService.updateCompany(companyId, company);
        return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Company>> listAllCompanies() {
        List<Company> companies = companyService.listAllCompanies();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

}
