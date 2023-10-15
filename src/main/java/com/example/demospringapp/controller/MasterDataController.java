package com.example.demospringapp.controller;

import com.example.demospringapp.dto.MasterDataResponse;
import com.example.demospringapp.repository.BodyTypeRepository;
import com.example.demospringapp.repository.FeatureRepository;
import com.example.demospringapp.repository.FuelTypeRepository;
import com.example.demospringapp.repository.GearboxTypeRepository;
import com.example.demospringapp.repository.MakeRepository;
import com.example.demospringapp.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/master-data")
public class MasterDataController {
    private final MakeRepository makeRepository;
    private final ModelRepository modelRepository;
    private final BodyTypeRepository bodyTypeRepository;
    private final FuelTypeRepository fuelTypeRepository;
    private final GearboxTypeRepository gearboxTypeRepository;
    private final FeatureRepository featureRepository;

    @Autowired
    public MasterDataController(
            MakeRepository makeRepository,
            ModelRepository modelRepository,
            BodyTypeRepository bodyTypeRepository,
            FuelTypeRepository fuelTypeRepository,
            GearboxTypeRepository gearboxTypeRepository,
            FeatureRepository featureRepository
    ) {
        this.makeRepository = makeRepository;
        this.modelRepository = modelRepository;
        this.bodyTypeRepository = bodyTypeRepository;
        this.fuelTypeRepository = fuelTypeRepository;
        this.gearboxTypeRepository = gearboxTypeRepository;
        this.featureRepository = featureRepository;
    }

    @GetMapping
    public ResponseEntity<MasterDataResponse> getMasterData() {
        MasterDataResponse response = new MasterDataResponse();

        response.setMakes(makeRepository.findAllMakes());
        response.setModels(modelRepository.findAllModels());
        response.setBodyTypes(bodyTypeRepository.findAllBodyTypes());
        response.setFuelTypes(fuelTypeRepository.findAllFuelTypes());
        response.setGearboxTypes(gearboxTypeRepository.findAllGearboxTypes());
        response.setFeatures(featureRepository.findAllFeatures());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
