package com.transportcompany.transportcompanyspring.repository;

import com.transportcompany.transportcompanyspring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByCompany_Id(long company_id);

    List<Employee> findByOrderByLicenseAsc();
}
