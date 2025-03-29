
package com.example.myapp.controller;

import com.example.myapp.model.Client;
import com.example.myapp.service.Client_serv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/client")
public class Client_cont {


    private final Client_serv client_serv;


    @Autowired
    public Client_cont(Client_serv client_serv) {
        this.client_serv = client_serv;
    }


    @GetMapping
    public List<Client> getAllClients() {
        return client_serv.getAllClients();
    }


    @GetMapping("/{number}")
    public Client getClientByNumber(@PathVariable String number) {
        return client_serv.getClientByNumber(number);
    }


    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return client_serv.createClient(client);
    }


    @PutMapping("/{number}")
    public Client updateClient(@PathVariable String number, @RequestBody Client client) {
        client.setClientNumber(number);
        return client_serv.updateClient(client);
    }


    @DeleteMapping("/{number}")
    public void deleteClient(@PathVariable String number) {
        client_serv.deleteClient(number);
    }
}
