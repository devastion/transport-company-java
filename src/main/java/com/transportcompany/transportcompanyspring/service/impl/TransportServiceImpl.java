package com.transportcompany.transportcompanyspring.service.impl;

import com.transportcompany.transportcompanyspring.entity.Transport;
import com.transportcompany.transportcompanyspring.repository.TransportRepository;
import com.transportcompany.transportcompanyspring.service.TransportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransportServiceImpl implements TransportService {
    private TransportRepository transportRepository;

    @Override
    public Transport addTransport(Transport transport) {
        return transportRepository.save(transport);
    }

    @Override
    public Transport removeTransport(long transportId) {
        Transport transport = transportRepository.findById(transportId).orElseThrow(() -> new IllegalArgumentException("Transport with this id is not found!"));
        transportRepository.deleteById(transportId);
        return transport;
    }

    @Override
    public Transport updateTransport(long transportId, Transport transport) {
        Transport transport1 = transportRepository.findById(transportId).orElseThrow(() -> new IllegalArgumentException("Transport with this id is not found!"));
        transport1.setDeparture(transport.getDeparture());
        transport1.setArrival(transport.getArrival());
        transport1.setPrice(transport.getPrice());
        transport1.setTransport(transport.getTransport());
        transport1.setCompany(transport.getCompany());
        transport1.setEmployee(transport.getEmployee());
        transport1.setStatus(transport.isStatus());
        transport1.setClients(transport.getClients());
        return transportRepository.save(transport1);
    }

    @Override
    public List<Transport> listAllTransports() {
        return transportRepository.findAll();
    }

    @Override
    public List<Transport> findByCompanyId(long companyId) {
        return transportRepository.findAllByCompany_Id(companyId);
    }

    @Override
    public List<Transport> findByCompanyIdAndStatus(long companyId, boolean status) {
        return transportRepository.findAllByCompany_IdAndStatus(companyId, status);
    }

    @Override
    public List<Transport> findByDeparture() {
        return transportRepository.findByOrderByDeparture();
    }
}
