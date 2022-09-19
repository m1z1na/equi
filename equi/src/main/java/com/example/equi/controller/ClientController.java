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
import java.util.List;

@RestController
public class ClientController<summ> {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    //DB
    @PostMapping(value = "/equi")

    public String create(@RequestBody Client equi) {
        return  clientService.create(equi);
//        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //DB
    @GetMapping(value = "/equi")
  //  public Integer read() {
    public String read() throws Exception {
//    public ResponseEntity<List<Client>> read() {
//        final List<Client> equi = clientService.readAll();
        return  clientService.readAll();
//        return equi != null &&  !equi.isEmpty()
//                ? new ResponseEntity<>(equi, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //DB
    @GetMapping(value = "/equi/{id}")
    public String read(@PathVariable(name = "id") int id) throws Exception {
        return clientService.read(id);
//        final Client client = clientService.read(id);
//
//        return client != null
//                ? new ResponseEntity<>(client, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/equi/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Client equi) {
        final boolean updated = clientService.update(equi, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    //DB
    @DeleteMapping(value = "/equi/{id}")
    public boolean delete(@PathVariable(name = "id") int id) {
//    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        return clientService.delete(id);

//        return deleted
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    //DB Стоимость
    @GetMapping(value = "/cost")
    protected @ResponseBody
    int doGetCost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return clientService.getCost();
    }
    //DB Прибыль
    @GetMapping(value = "/profit")
    protected @ResponseBody Integer doGetProfit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return clientService.getProfit();
    }
    //DB Стоимость для заказчика
    @GetMapping(value = "/costCustomer")
//    protected  @ResponseBody  Integer doGetCostCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
    protected  @ResponseBody  Integer doGetCostCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return clientService.getCostCustomer();
    }
}
