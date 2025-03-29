package com.example.myapp.service;

import com.example.myapp.model.ClientGroupId;
import com.example.myapp.model.ClientInGroup;
import com.example.myapp.repository.ClientInGroup_rep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientInGroup_serv {

    private final ClientInGroup_rep client_in_group_rep;

    @Autowired
    public ClientInGroup_serv(ClientInGroup_rep client_in_group_rep) {
        this.client_in_group_rep = client_in_group_rep;
    }


    public List<ClientInGroup> getAllClientInGroups() {
        return client_in_group_rep.findAll();
    }


    public ClientInGroup getClientInGroupByKey(ClientGroupId Key) {
        return client_in_group_rep.findById(Key).orElse(null);
    }


    public ClientInGroup createClientInGroup(ClientInGroup client_in_group) {
        return client_in_group_rep.save(client_in_group);
    }


    public ClientInGroup updateClientInGroup(ClientInGroup client_in_group) {
        return client_in_group_rep.save(client_in_group);
    }


    public void deleteClientInGroup(ClientGroupId Key) {
        client_in_group_rep.deleteById(Key);
    }

}




