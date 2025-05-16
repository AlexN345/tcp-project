package com.example.myapp.service;

import com.example.myapp.model.Client;
import com.example.myapp.model.Groupp;
import com.example.myapp.repository.Groupp_rep;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class Groupp_serv {

    private final Groupp_rep groupp_rep;

    @Autowired
    public Groupp_serv(Groupp_rep groupp_rep) {
        this.groupp_rep = groupp_rep;
    }


    public List<Groupp> getAllGroups() {
        return groupp_rep.findAll();
    }


    public Groupp getGroupById(Long id) {
        return groupp_rep.findById(id).orElse(null);
    }


    public Groupp saveGroup(Groupp groupp) {
        return groupp_rep.save(groupp);
    }
    public Groupp createGroup(String name) {
        Groupp groupp = new Groupp(name);
        return groupp_rep.save(groupp);
    }


    public Groupp updateGroup(Groupp groupp) {
        return groupp_rep.save(groupp);
    }

    public Groupp updateGroupName(Long gropId, String name) {
        Groupp groupp =groupp_rep.findById(gropId).orElseThrow(() -> new RuntimeException("Group not found"));
        groupp.setName(name);
        return groupp_rep.save(groupp);
    }


    public void deleteGroup(Long id) {
        groupp_rep.deleteById(id);
    }

    @Transactional
    public Groupp getGroupWithClients(Long groupId) {
        Groupp group = groupp_rep.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));
        // Инициализируем коллекцию клиентов группы
        Hibernate.initialize(group.getClients());
        return group;
    }

    @Transactional
    public Set<Client> getGroupClients(Long groupId) {
        Groupp group = groupp_rep.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));
        // Инициализируем коллекцию клиентов группы
        Hibernate.initialize(group.getClients());
        return group.getClients();
    }
}





