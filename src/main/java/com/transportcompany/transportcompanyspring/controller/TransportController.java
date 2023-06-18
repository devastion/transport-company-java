package com.transportcompany.transportcompanyspring.controller;

import com.transportcompany.transportcompanyspring.entity.Transport;
import com.transportcompany.transportcompanyspring.service.TransportService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/transports")
@AllArgsConstructor
public class TransportController {
    private TransportService transportService;

    @PostMapping
    public ResponseEntity<Transport> addTransport(@RequestBody Transport transport) {
        Transport transport1 = transportService.addTransport(transport);
        return new ResponseEntity<>(transport1, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Transport> removeTransport(@PathVariable("id") long transportId) {
        Transport removedTransport = transportService.removeTransport(transportId);
        return new ResponseEntity<>(removedTransport, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Transport> updateTransport(@PathVariable("id") long transportId, @RequestBody Transport transport) {
        Transport transport1 = transportService.updateTransport(transportId, transport);
        return new ResponseEntity<>(transport1, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Transport>> listAllTransports() {
        List<Transport> transports = transportService.listAllTransports();
        return new ResponseEntity<>(transports, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<List<Transport>> findAllByCompanyId(@PathVariable("id") long companyId) {
        List<Transport> allByCompanyId = transportService.findByCompanyId(companyId);
        return new ResponseEntity<>(allByCompanyId, HttpStatus.OK);
    }

    @GetMapping("{id}/{finished}")
    public ResponseEntity<List<Transport>> findAllByCompanyIdAndFinished(@PathVariable("id") long companyId, @PathVariable("finished") boolean finished) {
        List<Transport> allByCompanyIdAndFinished = transportService.findByCompanyIdAndStatus(companyId, finished);
        return new ResponseEntity<>(allByCompanyIdAndFinished, HttpStatus.OK);
    }
}
