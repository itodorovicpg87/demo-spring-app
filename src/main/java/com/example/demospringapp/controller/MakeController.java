package com.example.demospringapp.controller;

import com.example.demospringapp.domain.Make;
import com.example.demospringapp.repository.MakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/makes")
public class MakeController {
    private final MakeRepository makeRepository;

    @Autowired
    public MakeController(MakeRepository makeRepository) {
        this.makeRepository = makeRepository;
    }

    // Create (POST) - Create a new "make" entity
    @PostMapping
    public ResponseEntity<Make> createMake(@RequestBody Make make) {
        Make createdMake = makeRepository.save(make);
        return new ResponseEntity<>(createdMake, HttpStatus.CREATED);
    }

    // Read (GET) - Retrieve a single "make" entity by ID
    @GetMapping("/{id}")
    public ResponseEntity<Make> getMakeById(@PathVariable Long id) {
        Optional<Make> make = makeRepository.findById(id);
        if (make.isPresent()) {
            return new ResponseEntity<>(make.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Read (GET) - Retrieve a list of all "make" entities
    @GetMapping
    public ResponseEntity<List<Make>> getAllMakes() {
        List<Make> makes = makeRepository.findAll();
        return new ResponseEntity<>(makes, HttpStatus.OK);
    }

    // Update (PUT) - Update an existing "make" entity
    @PutMapping("/{id}")
    public ResponseEntity<Make> updateMake(@PathVariable Long id, @RequestBody Make updatedMake) {
        if (makeRepository.existsById(id)) {
            updatedMake.setId(id); // Set the ID to ensure you're updating the correct entity
            Make updated = makeRepository.save(updatedMake);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete (DELETE) - Delete a "make" entity by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMake(@PathVariable Long id) {
        if (makeRepository.existsById(id)) {
            makeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
