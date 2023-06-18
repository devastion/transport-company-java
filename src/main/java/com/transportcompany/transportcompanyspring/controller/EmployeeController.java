package com.transportcompany.transportcompanyspring.controller;

import com.transportcompany.transportcompanyspring.entity.Employee;
import com.transportcompany.transportcompanyspring.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;


    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee1, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Employee> removeEmployee(@PathVariable("id") long employeeId) {
        Employee removedEmployee = employeeService.removeEmployee(employeeId);
        return new ResponseEntity<>(removedEmployee, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId, @RequestBody Employee employee) {
        Employee employee1 = employeeService.updateEmployee(employeeId, employee);
        return new ResponseEntity<>(employee1, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> listAllEmployees() {
        List<Employee> employees = employeeService.listAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<List<Employee>> findByCompanyId(@PathVariable("id") long companyId) {
        List<Employee> employees = employeeService.findByCompanyId(companyId);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("orderByLicense")
    public ResponseEntity<List<Employee>> orderByLicense() {
        List<Employee> employees = employeeService.orderByLicense();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
