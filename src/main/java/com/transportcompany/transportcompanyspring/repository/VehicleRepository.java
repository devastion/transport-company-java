package com.transportcompany.transportcompanyspring.repository;

import com.transportcompany.transportcompanyspring.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findVehiclesByCompany_Id(long company_id);
}
