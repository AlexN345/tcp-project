package com.example.myapp.repository;

import com.example.myapp.model.Groupp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Groupp_rep extends JpaRepository<Groupp, Long> {
}