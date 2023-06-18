package com.transportcompany.transportcompanyspring.repository;

import com.transportcompany.transportcompanyspring.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
