package com.example.demospringapp.controller;

import com.example.demospringapp.domain.BodyType;
import com.example.demospringapp.repository.BodyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/body-types")
public class BodyTypeController {
    private final BodyTypeRepository bodyTypeRepository;

    @Autowired
    public BodyTypeController(BodyTypeRepository bodyTypeRepository) {
        this.bodyTypeRepository = bodyTypeRepository;
    }

    @PostMapping
    public ResponseEntity<BodyType> createBodyType(@RequestBody BodyType bodyType) {
        BodyType createdBodyType = bodyTypeRepository.save(bodyType);
        return new ResponseEntity<>(createdBodyType, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BodyType> getBodyTypeById(@PathVariable Long id) {
        Optional<BodyType> bodyType = bodyTypeRepository.findById(id);
        if (bodyType.isPresent()) {
            return new ResponseEntity<>(bodyType.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<BodyType>> getAllBodyTypes() {
        List<BodyType> bodyTypes = bodyTypeRepository.findAll();
        return new ResponseEntity<>(bodyTypes, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BodyType> updateBodyType(@PathVariable Long id, @RequestBody BodyType updatedBodyType) {
        if (bodyTypeRepository.existsById(id)) {
            updatedBodyType.setId(id);
            BodyType updated = bodyTypeRepository.save(updatedBodyType);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBodyType(@PathVariable Long id) {
        if (bodyTypeRepository.existsById(id)) {
            bodyTypeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
