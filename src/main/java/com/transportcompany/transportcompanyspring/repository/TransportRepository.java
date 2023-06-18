package com.transportcompany.transportcompanyspring.repository;

import com.transportcompany.transportcompanyspring.entity.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Long> {
    List<Transport> findAllByCompany_Id(long company_id);

    List<Transport> findAllByCompany_IdAndStatus(long company_id, boolean status);

    List<Transport> findByOrderByDeparture();
}
