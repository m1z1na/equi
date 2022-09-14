package com.example.equi.controller;

import com.example.equi.model.Client;
import com.example.equi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RestController
public class ClientController<summ> {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = "/CreateEqui")
    public ResponseEntity<?> create(@RequestBody Client equi) {
        clientService.create(equi);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/GetEqui")
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


    @GetMapping(value = "/GetEquiCost")
    protected void doGetCost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final List<Client> equi = clientService.readAll();
        Integer Sum = 0;

        for (int i = 0; i < equi.size(); i++) {
            Sum =  Sum + equi.get(i).getAmount() * equi.get(i).getCost();

        }
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(Sum);
        out.flush();
    }

    @GetMapping(value = "/GetEquiProfit")
    protected void doGetProfit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final List<Client> equi = clientService.readAll();
        Integer Sum = 0;

        for (int i = 0; i < equi.size(); i++) {
            Sum =  Sum + ( equi.get(i).getAmount() * equi.get(i).getCost()  +
                           equi.get(i).getAmount() * equi.get(i).getCost() / 100 * equi.get(i).getMarkup() -
                           equi.get(i).getAmount() * equi.get(i).getCost() );

        }
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(Sum);
        out.flush();
    }
    @GetMapping(value = "/GetEquiCostCustomer")
    protected void doGetCostCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final List<Client> equi = clientService.readAll();
        Integer Sum = 0;

        for (int i = 0; i < equi.size(); i++) {
            Sum =  Sum + ( equi.get(i).getAmount() * equi.get(i).getCost() +
                           equi.get(i).getAmount() * equi.get(i).getCost() / 100 * equi.get(i).getMarkup() );

        }
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(Sum);
        out.flush();
    }
}
