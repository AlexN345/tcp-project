

package com.example.myapp.service;

import com.example.myapp.model.Client;
import com.example.myapp.repository.Client_rep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class Client_serv {

    //@Autowired
    private Client_rep client_rep;

    @Autowired
    public Client_serv(Client_rep client_rep) {
        this.client_rep = client_rep;
    }


    public List<Client> getAllClients() {
        return client_rep.findAll();
    }


    public Client getClientByNumber(String phone_number) {
        return client_rep.findById(phone_number).orElse(null);
    }


    public Client createClient(Client client) {
        return client_rep.save(client);
    }


    public Client updateClient(Client client) {
        return client_rep.save(client);
    }


    public void deleteClient(String phone_number) {
        client_rep.deleteById(phone_number);
    }

}




