package com.example.demospringapp.repository;

import com.example.demospringapp.domain.BodyType;
import com.example.demospringapp.domain.GearboxType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GearboxTypeRepository extends JpaRepository<GearboxType, Long> {
    @Query("SELECT DISTINCT gt.name FROM GearboxType gt")
    List<String> findAllGearboxTypes();
}
