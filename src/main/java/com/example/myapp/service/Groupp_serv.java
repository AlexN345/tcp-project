package com.example.myapp.service;

import com.example.myapp.model.Groupp;
import com.example.myapp.repository.Groupp_rep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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


    public Groupp createGroup(Groupp groupp) {
        return groupp_rep.save(groupp);
    }


    public Groupp updateGroup(Groupp groupp) {
        return groupp_rep.save(groupp);
    }


    public void deleteGroup(Long id) {
        groupp_rep.deleteById(id);
    }

}





