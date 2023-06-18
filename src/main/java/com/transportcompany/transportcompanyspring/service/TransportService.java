package com.transportcompany.transportcompanyspring.service;

import com.transportcompany.transportcompanyspring.entity.Transport;

import java.util.List;

public interface TransportService {
    Transport addTransport(Transport transport);

    Transport removeTransport(long transportId);

    Transport updateTransport(long transportId, Transport transport);

    List<Transport> listAllTransports();

    List<Transport> findByCompanyId(long companyId);

    List<Transport> findByCompanyIdAndStatus(long companyId, boolean status);

    List<Transport> findByDeparture();
}
