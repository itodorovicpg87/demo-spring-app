package com.example.demospringapp.repository;

import com.example.demospringapp.domain.BodyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BodyTypeRepository extends JpaRepository<BodyType, Long> {
    @Query("SELECT DISTINCT bt.name FROM BodyType bt")
    List<String> findAllBodyTypes();
}
