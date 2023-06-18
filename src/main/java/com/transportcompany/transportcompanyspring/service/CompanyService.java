package com.transportcompany.transportcompanyspring.service;

import com.transportcompany.transportcompanyspring.entity.Company;

import java.util.List;

public interface CompanyService {
    Company addCompany(Company company);

    Company removeCompany(long companyId);

    Company updateCompany(long companyId, Company company);

    List<Company> listAllCompanies();
}
