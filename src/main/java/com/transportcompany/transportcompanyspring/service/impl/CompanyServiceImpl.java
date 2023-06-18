package com.transportcompany.transportcompanyspring.service.impl;

import com.transportcompany.transportcompanyspring.entity.Company;
import com.transportcompany.transportcompanyspring.repository.CompanyRepository;
import com.transportcompany.transportcompanyspring.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    @Override
    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company removeCompany(long companyId) {
        Company removedCompany = companyRepository.findById((companyId)).orElseThrow(() -> new IllegalArgumentException("Company with this id doesn't exist."));
        companyRepository.deleteById(companyId);
        return removedCompany;
    }

    @Override
    public Company updateCompany(long companyId, Company company) {
        Company existingCompany = companyRepository.findById(companyId).get();
        existingCompany.setName(company.getName());
        return companyRepository.save(existingCompany);
    }

    @Override
    public List<Company> listAllCompanies() {
        return companyRepository.findAll();
    }
}
