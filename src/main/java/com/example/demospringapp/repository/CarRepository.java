package com.example.demospringapp.repository;

import com.example.demospringapp.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    Car findBySlug(String slug);

    @Query("SELECT c FROM Car c " +
            "JOIN c.model m " +
            "JOIN c.features f " +
            "WHERE (:makeId IS NULL OR m.make.id = :makeId) " +
            "AND (:modelId IS NULL OR m.id = :modelId) " +
            "AND (:bodyTypeId IS NULL OR c.bodyType.id = :bodyTypeId) " +
            "AND (:fuelTypeId IS NULL OR c.fuelType.id = :fuelTypeId) " +
            "AND (:gearboxTypeId IS NULL OR c.gearboxType.id = :gearboxTypeId) " +
            "AND (:featureId IS NULL OR f.id = :featureId) " +
            "AND (:query IS NULL OR " +
            "    LOWER(m.make.name) LIKE LOWER(CONCAT('%', :query, '%')) " +
            "    OR LOWER(m.name) LIKE LOWER(CONCAT('%', :query, '%')) " +
            "    OR LOWER(f.name) LIKE LOWER(CONCAT('%', :query, '%')))")
    List<Car> findCarsByFilters(
            @Param("makeId") Long makeId,
            @Param("modelId") Long modelId,
            @Param("bodyTypeId") Long bodyTypeId,
            @Param("fuelTypeId") Long fuelTypeId,
            @Param("gearboxTypeId") Long gearboxTypeId,
            @Param("featureId") Long featureId,
            @Param("query") String query
    );
}
