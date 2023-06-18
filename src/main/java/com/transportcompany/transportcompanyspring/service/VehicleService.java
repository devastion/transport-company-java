package com.transportcompany.transportcompanyspring.service;

import com.transportcompany.transportcompanyspring.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle addVehicle(Vehicle vehicle);

    Vehicle removeVehicle(long vehicleId);

    Vehicle updateVehicle(long vehicleId, Vehicle vehicle);

    List<Vehicle> listAllVehicles();

    List<Vehicle> findByCompanyId(long companyId);
}
