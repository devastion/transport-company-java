package com.transportcompany.transportcompanyspring.controller;

import com.transportcompany.transportcompanyspring.entity.Client;
import com.transportcompany.transportcompanyspring.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clients")
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        Client client1 = clientService.addClient(client);
        return new ResponseEntity<>(client1, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Client> removeClient(@PathVariable("id") long clientId) {
        Client removedClient = clientService.removeClient(clientId);
        return new ResponseEntity<>(removedClient, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") long clientId, @RequestBody Client client) {
        Client client1 = clientService.updateClient(clientId, client);
        return new ResponseEntity<>(client1, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Client>> listAllClients() {
        List<Client> clients = clientService.listAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<List<Client>> findAllByCompanyId(@PathVariable("id") long companyId) {
        List<Client> clients = clientService.findByCompanyId(companyId);
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
}
