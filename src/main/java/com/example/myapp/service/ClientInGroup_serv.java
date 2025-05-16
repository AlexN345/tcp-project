package com.example.myapp.service;

import com.example.myapp.model.*;
import com.example.myapp.repository.ClientInGroup_rep;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

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
    public ClientInGroup getClientInGroupByClientAndGroup(Long clientId, Long groupId) {
        ClientGroupId key = new ClientGroupId(clientId,groupId);
        return client_in_group_rep.findById(key).orElse(null);
    }

    public ClientInGroup saveClientInGroup(ClientInGroup client_in_group) {
        return client_in_group_rep.save(client_in_group);
    }

    public ClientInGroup createClientInGroup(Client client, Groupp groupp) {
        ClientInGroup client_in_group = new ClientInGroup(client, groupp);
        return client_in_group_rep.save(client_in_group);
    }


    public ClientInGroup updateClientInGroup(ClientInGroup client_in_group) {
        return client_in_group_rep.save(client_in_group);
    }


    public void deleteClientInGroup(Client client, Groupp groupp) {
        ClientGroupId key = new ClientGroupId(client.getClientId(), groupp.getGroupId());
        client_in_group_rep.deleteById(key);
    }
    @Transactional
    public ClientInGroup getClientInGroupWithTasks(Long clientId, Long groupId) {
        ClientGroupId key = new ClientGroupId(clientId,groupId);
        ClientInGroup clientInGroup = client_in_group_rep.findById(key).orElseThrow(() -> new RuntimeException("ClientInGroup not found"));
        // Инициализируем коллекцию клиентов группы
        Hibernate.initialize(clientInGroup.getTasks());
        return clientInGroup;
    }

    @Transactional
    public Set<Task> getClientInGroupTasks(Long clientId, Long groupId) {
        ClientGroupId key = new ClientGroupId(clientId,groupId);
        ClientInGroup clientInGroup = client_in_group_rep.findById(key).orElseThrow(() -> new RuntimeException("ClientInGroup not found"));
        // Инициализируем коллекцию клиентов группы
        Hibernate.initialize(clientInGroup.getTasks());
        return clientInGroup.getTasks();
    }

}




