package com.example.demospringapp.repository;

import com.example.demospringapp.domain.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
    @Query("SELECT DISTINCT f.name FROM Feature f")
    List<String> findAllFeatures();
}
