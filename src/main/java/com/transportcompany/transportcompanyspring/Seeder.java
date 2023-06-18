package com.transportcompany.transportcompanyspring;

import com.transportcompany.transportcompanyspring.entity.*;
import com.transportcompany.transportcompanyspring.enums.License;
import com.transportcompany.transportcompanyspring.enums.TransportType;
import com.transportcompany.transportcompanyspring.service.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class Seeder implements ApplicationRunner {
    private final CompanyService companyService;
    private final EmployeeService employeeService;
    private final VehicleService vehicleService;
    private final ClientService clientService;
    private final TransportService transportService;

    public Seeder(CompanyService companyService, EmployeeService employeeService, VehicleService vehicleService, ClientService clientService, TransportService transportService) {
        this.companyService = companyService;
        this.employeeService = employeeService;
        this.vehicleService = vehicleService;
        this.clientService = clientService;
        this.transportService = transportService;
    }

    private void companySeed() {
        List<Company> companyList = new ArrayList<>();
        companyList.add(new Company("Company 1"));
        companyList.add(new Company("Company 2"));
        companyList.add(new Company("Company 3"));

        companyList.forEach(companyService::addCompany);
    }

    private void employeeSeed() {
        List<Employee> employeeList = new ArrayList<>();
        List<Company> companyList = companyService.listAllCompanies();
        employeeList.add(new Employee("Gosho", License.B, companyList.get(0), new BigDecimal("1502.52")));
        employeeList.add(new Employee("Pesho", License.C, companyList.get(0), new BigDecimal("1572.52")));
        employeeList.add(new Employee("Ivan", License.B, companyList.get(1), new BigDecimal("1502.52")));
        employeeList.add(new Employee("Blagoi", License.C, companyList.get(1), new BigDecimal("1552.52")));
        employeeList.add(new Employee("Dragan", License.B, companyList.get(2), new BigDecimal("1602.52")));
        employeeList.add(new Employee("Petkan", License.C, companyList.get(2), new BigDecimal("1752.52")));
        employeeList.forEach(employeeService::addEmployee);
    }

    private void vehicleSeed() {
        List<Vehicle> vehicleList = new ArrayList<>();
        List<Company> companyList = companyService.listAllCompanies();
        vehicleList.add(new Vehicle(companyList.get(0), License.B, TransportType.PASSENGER, 8));
        vehicleList.add(new Vehicle(companyList.get(0), License.C, TransportType.CARGO, 3000));
        vehicleList.add(new Vehicle(companyList.get(1), License.B, TransportType.PASSENGER, 5));
        vehicleList.add(new Vehicle(companyList.get(1), License.C, TransportType.CARGO, 3500));
        vehicleList.add(new Vehicle(companyList.get(2), License.B, TransportType.PASSENGER, 3));
        vehicleList.add(new Vehicle(companyList.get(2), License.C, TransportType.CARGO, 5000));
        vehicleList.forEach(vehicleService::addVehicle);
    }

    private void clientSeed() {
        List<Client> clientList = new ArrayList<>();
        List<Company> companyList = companyService.listAllCompanies();
        clientList.add(new Client("Ema1", companyList.get(0)));
        clientList.add(new Client("Joe1", companyList.get(0)));
        clientList.add(new Client("Doe1", companyList.get(0)));
        clientList.add(new Client("Ema2", companyList.get(1)));
        clientList.add(new Client("Joe2", companyList.get(1)));
        clientList.add(new Client("Doe2", companyList.get(1)));
        clientList.add(new Client("Ema3", companyList.get(2)));
        clientList.add(new Client("Joe3", companyList.get(2)));
        clientList.add(new Client("Doe3", companyList.get(2)));
        clientList.forEach(clientService::addClient);
    }

    private void transportSeed() {
        List<Transport> transportList = new ArrayList<>();
        List<Company> companyList = companyService.listAllCompanies();
        List<Client> clientList = clientService.listAllClients();
        List<Employee> employeeList1 = employeeService.findByCompanyId(1);
        List<Employee> employeeList2 = employeeService.findByCompanyId(2);
        List<Employee> employeeList3 = employeeService.findByCompanyId(3);
        List<Client> clientList1 = new ArrayList<>();
        clientList1.add(clientList.get(1));
        clientList1.add(clientList.get(2));
        List<Client> clientList2 = new ArrayList<>();
        clientList2.add(clientList.get(3));
        clientList2.add(clientList.get(4));
        List<Client> clientList3 = new ArrayList<>();
        clientList3.add(clientList.get(6));
        clientList3.add(clientList.get(7));
        List<Client> cargoList1 = new ArrayList<>();
        cargoList1.add(clientList.get(0));
        List<Client> cargoList2 = new ArrayList<>();
        cargoList1.add(clientList.get(5));
        List<Client> cargoList3 = new ArrayList<>();
        cargoList1.add(clientList.get(8));


        transportList.add(new Transport("Sofia", "Paris", new BigDecimal("50"), TransportType.PASSENGER, 25, companyList.get(0), employeeList1.get(0), false, clientList1));
        transportList.add(new Transport("Sofia", "Paris", new BigDecimal("5"), TransportType.CARGO, 500, companyList.get(0), employeeList1.get(1), false, cargoList1));
        transportList.add(new Transport("Plovdiv", "Burgas", new BigDecimal("50"), TransportType.PASSENGER, 15, companyList.get(1), employeeList2.get(0), false, clientList2));
        transportList.add(new Transport("London", "Paris", new BigDecimal("5"), TransportType.CARGO, 500, companyList.get(1), employeeList2.get(1), false, cargoList2));
        transportList.add(new Transport("Vidin", "Maroco", new BigDecimal("150"), TransportType.PASSENGER, 15, companyList.get(2), employeeList3.get(0), false, clientList3));
        transportList.add(new Transport("London", "Paris", new BigDecimal("5"), TransportType.CARGO, 500, companyList.get(2), employeeList3.get(1), false, cargoList3));

        transportList.forEach(transportService::addTransport);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        companySeed();
        employeeSeed();
        vehicleSeed();
        clientSeed();
        transportSeed();
    }
}
