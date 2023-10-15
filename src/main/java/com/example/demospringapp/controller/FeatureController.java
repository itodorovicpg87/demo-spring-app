package com.example.demospringapp.controller;

import com.example.demospringapp.domain.Feature;
import com.example.demospringapp.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/features")
public class FeatureController {
    private final FeatureRepository featureRepository;

    @Autowired
    public FeatureController(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    @PostMapping
    public ResponseEntity<Feature> createFeature(@RequestBody Feature feature) {
        Feature createdFeature = featureRepository.save(feature);
        return new ResponseEntity<>(createdFeature, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feature> getFeatureById(@PathVariable Long id) {
        Optional<Feature> feature = featureRepository.findById(id);
        if (feature.isPresent()) {
            return new ResponseEntity<>(feature.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Feature>> getAllFeatures() {
        List<Feature> features = featureRepository.findAll();
        return new ResponseEntity<>(features, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feature> updateFeature(@PathVariable Long id, @RequestBody Feature updatedFeature) {
        if (featureRepository.existsById(id)) {
            updatedFeature.setId(id);
            Feature updated = featureRepository.save(updatedFeature);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeature(@PathVariable Long id) {
        if (featureRepository.existsById(id)) {
            featureRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
