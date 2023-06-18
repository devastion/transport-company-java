package com.transportcompany.transportcompanyspring.service.impl;

import com.transportcompany.transportcompanyspring.entity.Vehicle;
import com.transportcompany.transportcompanyspring.repository.VehicleRepository;
import com.transportcompany.transportcompanyspring.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle removeVehicle(long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new IllegalArgumentException("Vehicle with this id not found!"));
        vehicleRepository.deleteById(vehicleId);
        return vehicle;
    }

    @Override
    public Vehicle updateVehicle(long vehicleId, Vehicle vehicle) {
        Vehicle existingVehicle = vehicleRepository.findById(vehicleId).get();
        existingVehicle.setLicense(vehicle.getLicense());
        existingVehicle.setType(vehicle.getType());
        existingVehicle.setCapacity(vehicle.getCapacity());
        return vehicleRepository.save(existingVehicle);
    }

    @Override
    public List<Vehicle> listAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public List<Vehicle> findByCompanyId(long companyId) {
        List<Vehicle> vehicles = vehicleRepository.findVehiclesByCompany_Id(companyId);
        return vehicles;
    }
}
