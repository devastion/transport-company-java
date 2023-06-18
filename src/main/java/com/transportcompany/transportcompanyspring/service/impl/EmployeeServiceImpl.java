package com.transportcompany.transportcompanyspring.service.impl;

import com.transportcompany.transportcompanyspring.entity.Employee;
import com.transportcompany.transportcompanyspring.repository.EmployeeRepository;
import com.transportcompany.transportcompanyspring.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee removeEmployee(long employeeId) {
        Employee removedEmployee = employeeRepository.findById(employeeId).orElseThrow(() -> new IllegalArgumentException("Employee with this id is not found!"));
        employeeRepository.deleteById(employeeId);
        return removedEmployee;
    }

    @Override
    public Employee updateEmployee(long employeeId, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employeeId).orElseThrow(() -> new IllegalArgumentException("Employee with this id is not found!"));
        existingEmployee.setName(employee.getName());
        existingEmployee.setLicense(employee.getLicense());
        existingEmployee.setCompany(employee.getCompany());
        existingEmployee.setSalary(employee.getSalary());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public List<Employee> listAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findByCompanyId(long company_id) {
        return employeeRepository.findAllByCompany_Id(company_id);
    }

    @Override
    public List<Employee> orderByLicense() {
        return employeeRepository.findByOrderByLicenseAsc();
    }
}
