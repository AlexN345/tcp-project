package com.example.myapp.controller;


import com.example.myapp.model.Responsibility;
import com.example.myapp.service.Responsibility_serv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responsibility")
public class Responsibility_cont {

    private final Responsibility_serv responsibility_serv;

    @Autowired
    public Responsibility_cont(Responsibility_serv responsibility_serv) {
        this.responsibility_serv = responsibility_serv;
    }

    @GetMapping
    public List<Responsibility> getAllResponsibilities() {
        return responsibility_serv.getAllResponsibilities();
    }

    @GetMapping("/{id}")
    public Responsibility getResponsibilityById(@PathVariable Long id) {
        return responsibility_serv.getResponsibilityById(id);
    }

    @PostMapping
    public Responsibility createResponsibility(@RequestBody Responsibility responsibility) {
        return responsibility_serv.saveResponsibility(responsibility);
    }

    @PutMapping("/{id}")
    public Responsibility updateResponsibility(@PathVariable Long id, @RequestBody Responsibility responsibility) {
        responsibility.setResponsibilityId(id);
        return responsibility_serv.updateResponsibility(responsibility);
    }

    @DeleteMapping("/{id}")
    public void deleteResponsibility(@PathVariable Long id) {
        responsibility_serv.deleteResponsibility(id);
    }
}
