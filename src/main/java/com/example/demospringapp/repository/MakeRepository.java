package com.example.demospringapp.repository;

import com.example.demospringapp.domain.Make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface MakeRepository extends JpaRepository<Make, Long> {
    @Query("SELECT DISTINCT m.name FROM Make m")
    List<String> findAllMakes();
}
