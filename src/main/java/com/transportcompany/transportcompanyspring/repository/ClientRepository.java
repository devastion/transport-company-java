package com.transportcompany.transportcompanyspring.repository;

import com.transportcompany.transportcompanyspring.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findAllByCompany_Id(long company_id);
}
