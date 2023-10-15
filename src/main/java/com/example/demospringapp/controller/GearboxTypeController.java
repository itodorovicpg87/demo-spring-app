package com.example.demospringapp.controller;

import com.example.demospringapp.domain.GearboxType;
import com.example.demospringapp.repository.GearboxTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gearbox-types")
public class GearboxTypeController {
    private final GearboxTypeRepository gearboxTypeRepository;

    @Autowired
    public GearboxTypeController(GearboxTypeRepository gearboxTypeRepository) {
        this.gearboxTypeRepository = gearboxTypeRepository;
    }

    @PostMapping
    public ResponseEntity<GearboxType> createGearboxType(@RequestBody GearboxType gearboxType) {
        GearboxType createdGearboxType = gearboxTypeRepository.save(gearboxType);
        return new ResponseEntity<>(createdGearboxType, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GearboxType> getGearboxTypeById(@PathVariable Long id) {
        Optional<GearboxType> gearboxType = gearboxTypeRepository.findById(id);
        if (gearboxType.isPresent()) {
            return new ResponseEntity<>(gearboxType.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<GearboxType>> getAllGearboxTypes() {
        List<GearboxType> gearboxTypes = gearboxTypeRepository.findAll();
        return new ResponseEntity<>(gearboxTypes, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GearboxType> updateGearboxType(@PathVariable Long id, @RequestBody GearboxType updatedGearboxType) {
        if (gearboxTypeRepository.existsById(id)) {
            updatedGearboxType.setId(id);
            GearboxType updated = gearboxTypeRepository.save(updatedGearboxType);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGearboxType(@PathVariable Long id) {
        if (gearboxTypeRepository.existsById(id)) {
            gearboxTypeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
