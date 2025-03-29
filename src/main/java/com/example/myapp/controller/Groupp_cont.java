package com.example.myapp.controller;

import com.example.myapp.model.Groupp;
import com.example.myapp.service.Groupp_serv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groupp")
public class Groupp_cont {

    private final Groupp_serv groupp_serv;

    @Autowired
    public Groupp_cont(Groupp_serv groupp_serv) {
        this.groupp_serv = groupp_serv;
    }

    @GetMapping
    public List<Groupp> getAllGroups() {
        return groupp_serv.getAllGroups();
    }

    @GetMapping("/{id}")
    public Groupp getGroupById(@PathVariable Long id) {
        return groupp_serv.getGroupById(id);
    }

    @PostMapping
    public Groupp createGroup(@RequestBody Groupp groupp) {
        return groupp_serv.createGroup(groupp);
    }

    @PutMapping("/{id}")
    public Groupp updateGroup(@PathVariable Long id, @RequestBody Groupp groupp) {
        groupp.setGroupId(id);
        return groupp_serv.updateGroup(groupp);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Long id) {
        groupp_serv.deleteGroup(id);
    }
}
