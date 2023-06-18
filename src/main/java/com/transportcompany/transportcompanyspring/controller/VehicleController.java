package com.transportcompany.transportcompanyspring.controller;

import com.transportcompany.transportcompanyspring.entity.Vehicle;
import com.transportcompany.transportcompanyspring.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vehicles")
@AllArgsConstructor
public class VehicleController {
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
        Vehicle vehicle1 = vehicleService.addVehicle(vehicle);
        return new ResponseEntity<>(vehicle1, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Vehicle> removeVehicle(@PathVariable("id") long vehicleId) {
        Vehicle deletedVehicle = vehicleService.removeVehicle(vehicleId);
        return new ResponseEntity<>(deletedVehicle, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") long vehicleId, @RequestBody Vehicle vehicle) {
        Vehicle updatedVehicle = vehicleService.updateVehicle(vehicleId, vehicle);
        return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> listAllVehicles() {
        List<Vehicle> vehicles = vehicleService.listAllVehicles();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<List<Vehicle>> findVehiclesByCompanyId(@PathVariable("id") long companyId) {
        List<Vehicle> vehicles = vehicleService.findByCompanyId(companyId);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }
}
