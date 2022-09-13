package com.example.equi.controller;

import com.example.equi.model.Client;
import com.example.equi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController<summ> {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = "/createEqui")
    public ResponseEntity<?> create(@RequestBody Client equi) {
        clientService.create(equi);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/getEqui")
  //  public Integer read() {
    public ResponseEntity<List<Client>> read() {
        final List<Client> equi = clientService.readAll();

        return equi != null &&  !equi.isEmpty()
                ? new ResponseEntity<>(equi, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/GetEqui/{id}")
    public ResponseEntity<Client> read(@PathVariable(name = "id") int id) {
        final Client client = clientService.read(id);

        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/ChangeEqui/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Client equi) {
        final boolean updated = clientService.update(equi, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/DeleteEqui/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = clientService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
