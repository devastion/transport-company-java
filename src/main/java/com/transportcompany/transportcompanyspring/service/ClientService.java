package com.transportcompany.transportcompanyspring.service;

import com.transportcompany.transportcompanyspring.entity.Client;

import java.util.List;

public interface ClientService {
    Client addClient(Client client);

    Client removeClient(long clientId);

    Client updateClient(long clientId, Client client);

    List<Client> listAllClients();

    List<Client> findByCompanyId(long companyId);

}
