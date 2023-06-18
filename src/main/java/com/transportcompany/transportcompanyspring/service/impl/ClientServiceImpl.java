package com.transportcompany.transportcompanyspring.service.impl;

import com.transportcompany.transportcompanyspring.entity.Client;
import com.transportcompany.transportcompanyspring.repository.ClientRepository;
import com.transportcompany.transportcompanyspring.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client removeClient(long clientId) {
        Client removedClient = clientRepository.findById(clientId).orElseThrow(() -> new IllegalArgumentException("Client with this id doesn't exist"));
        clientRepository.deleteById(clientId);
        return removedClient;
    }

    @Override
    public Client updateClient(long clientId, Client client) {
        Client existingClient = clientRepository.findById(clientId).orElseThrow(() -> new IllegalArgumentException("Client with this id doesn't exist"));
        existingClient.setName(client.getName());
        existingClient.setCompany(client.getCompany());
        return clientRepository.save(existingClient);
    }

    @Override
    public List<Client> listAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> findByCompanyId(long companyId) {
        return clientRepository.findAllByCompany_Id(companyId);
    }
}
