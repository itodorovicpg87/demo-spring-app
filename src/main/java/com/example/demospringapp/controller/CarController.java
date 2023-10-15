package com.example.demospringapp.controller;

import com.example.demospringapp.domain.Car;
import com.example.demospringapp.dto.CarDTO;
import com.example.demospringapp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car createdCar = carService.createCar(car);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    @GetMapping("/{slug}")
    public ResponseEntity<Car> getCarBySlug(@PathVariable String slug) {
        Car car = carService.getCarBySlug(slug);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCars(
            @RequestParam(value = "make_id", required = false) Long makeId,
            @RequestParam(value = "model_id", required = false) Long modelId,
            @RequestParam(value = "body_type_id", required = false) Long bodyTypeId,
            @RequestParam(value = "fuel_type_id", required = false) Long fuelTypeId,
            @RequestParam(value = "gearbox_type_id", required = false) Long gearboxTypeId,
            @RequestParam(value = "feature_id", required = false) Long featureId,
            @RequestParam(value = "query", required = false) String query
    ) {
        List<CarDTO> cars = carService.getAllCarsWithModifiedFormat(makeId, modelId, bodyTypeId, fuelTypeId, gearboxTypeId, featureId, query);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }
}
