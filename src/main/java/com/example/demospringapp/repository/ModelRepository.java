package com.example.demospringapp.repository;

import com.example.demospringapp.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {
    @Query("SELECT DISTINCT m.name FROM Model m")
    List<String> findAllModels();
}
