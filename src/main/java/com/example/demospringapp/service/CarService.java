package com.example.demospringapp.service;

import com.example.demospringapp.domain.Car;
import com.example.demospringapp.dto.CarDTO;
import com.example.demospringapp.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import com.example.demospringapp.domain.Feature;


@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public Car getCarBySlug(String slug) {
        return carRepository.findBySlug(slug);
    }

    public List<Car> getAllCars(
            Long makeId, Long modelId, Long bodyTypeId, Long fuelTypeId, Long gearboxTypeId, Long featureId, String query
    ) {
        return carRepository.findCarsByFilters(makeId, modelId, bodyTypeId, fuelTypeId, gearboxTypeId, featureId, query);
    }

    public List<CarDTO> getAllCarsWithModifiedFormat(
            Long makeId, Long modelId, Long bodyTypeId, Long fuelTypeId, Long gearboxTypeId, Long featureId, String query
    ) {
        List<Car> cars = carRepository.findCarsByFilters(makeId, modelId, bodyTypeId, fuelTypeId, gearboxTypeId, featureId, query);
        return cars.stream()
                .map(this::mapCarToCarDTO)
                .collect(Collectors.toList());
    }

    private CarDTO mapCarToCarDTO(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setMake(car.getModel().getMake().getName());
        carDTO.setModel(car.getModel().getName());
        carDTO.setBodyType(car.getBodyType().getName());
        carDTO.setFuelType(car.getFuelType().getName());
        carDTO.setGearboxType(car.getGearboxType().getName());
        carDTO.setFeatureNames(
                car.getFeatures().stream()
                        .map(Feature::getName)
                        .collect(Collectors.toList())
        );
        carDTO.setDescription(car.getDescription());
        carDTO.setRegNumber(car.getRegNumber());
        carDTO.setPrice(car.getPrice());
        carDTO.setYearModel(car.getYearModel());
        carDTO.setMileage(car.getMileage());
        carDTO.setHorsepower(car.getHorsepower());
        carDTO.setSlug(car.getSlug());
        carDTO.setId(car.getId());
        carDTO.setCreatedDate(car.getCreatedDate());
        return carDTO;
    }

}
