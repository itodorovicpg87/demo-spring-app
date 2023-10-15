package com.example.demospringapp.controller;

import com.example.demospringapp.domain.FuelType;
import com.example.demospringapp.repository.FuelTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fuel-types")
public class FuelTypeController {
    private final FuelTypeRepository fuelTypeRepository;

    @Autowired
    public FuelTypeController(FuelTypeRepository fuelTypeRepository) {
        this.fuelTypeRepository = fuelTypeRepository;
    }

    @PostMapping
    public ResponseEntity<FuelType> createFuelType(@RequestBody FuelType fuelType) {
        FuelType createdFuelType = fuelTypeRepository.save(fuelType);
        return new ResponseEntity<>(createdFuelType, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuelType> getFuelTypeById(@PathVariable Long id) {
        Optional<FuelType> fuelType = fuelTypeRepository.findById(id);
        if (fuelType.isPresent()) {
            return new ResponseEntity<>(fuelType.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<FuelType>> getAllFuelTypes() {
        List<FuelType> fuelTypes = fuelTypeRepository.findAll();
        return new ResponseEntity<>(fuelTypes, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuelType> updateFuelType(@PathVariable Long id, @RequestBody FuelType updatedFuelType) {
        if (fuelTypeRepository.existsById(id)) {
            updatedFuelType.setId(id);
            FuelType updated = fuelTypeRepository.save(updatedFuelType);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuelType(@PathVariable Long id) {
        if (fuelTypeRepository.existsById(id)) {
            fuelTypeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
