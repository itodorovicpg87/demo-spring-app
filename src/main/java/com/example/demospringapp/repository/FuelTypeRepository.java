package com.example.demospringapp.repository;

import com.example.demospringapp.domain.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FuelTypeRepository extends JpaRepository<FuelType, Long> {
    @Query("SELECT DISTINCT ft.name FROM FuelType ft")
    List<String> findAllFuelTypes();
}
