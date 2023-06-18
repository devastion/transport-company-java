package com.transportcompany.transportcompanyspring.service;

import com.transportcompany.transportcompanyspring.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    Employee removeEmployee(long employeeId);

    Employee updateEmployee(long employeeId, Employee employee);

    List<Employee> listAllEmployees();

    List<Employee> findByCompanyId(long companyId);
}
