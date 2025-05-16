package com.example.myapp.service;

import com.example.myapp.model.Groupp;
import com.example.myapp.model.Responsibility;
import com.example.myapp.repository.Responsibility_rep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Responsibility_serv {

    private final Responsibility_rep responsibility_rep;

    @Autowired
    public Responsibility_serv(Responsibility_rep responsibility_rep) {
        this.responsibility_rep = responsibility_rep;
    }


    public List<Responsibility> getAllResponsibilities() {
        return responsibility_rep.findAll();
    }


    public Responsibility getResponsibilityById(Long id) {
        return responsibility_rep.findById(id).orElse(null);
    }


    public Responsibility saveResponsibility(Responsibility responsibility) {
        return responsibility_rep.save(responsibility);
    }

    public Responsibility createResponsibility(String name, String image) {
        Responsibility responsibility = new Responsibility(name, image);
        return responsibility_rep.save(responsibility);
    }

    public Responsibility updateResponsibility(Responsibility responsibility) {
        return responsibility_rep.save(responsibility);
    }


    public void deleteResponsibility(Long id) {
        responsibility_rep.deleteById(id);
    }

}





