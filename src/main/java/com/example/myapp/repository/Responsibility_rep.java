package com.example.myapp.repository;

import com.example.myapp.model.Responsibility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Responsibility_rep extends JpaRepository<Responsibility, Long> {
}