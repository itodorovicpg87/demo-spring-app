package com.example.demospringapp.dto;

import java.util.List;

public class MasterDataResponse {
    private List<String> makes;
    private List<String> models;
    private List<String> bodyTypes;
    private List<String> fuelTypes;
    private List<String> gearboxTypes;
    private List<String> features;

    public MasterDataResponse() {
    }

    public List<String> getMakes() {
        return makes;
    }

    public void setMakes(List<String> makes) {
        this.makes = makes;
    }

    public List<String> getModels() {
        return models;
    }

    public void setModels(List<String> models) {
        this.models = models;
    }

    public List<String> getBodyTypes() {
        return bodyTypes;
    }

    public void setBodyTypes(List<String> bodyTypes) {
        this.bodyTypes = bodyTypes;
    }

    public List<String> getFuelTypes() {
        return fuelTypes;
    }

    public void setFuelTypes(List<String> fuelTypes) {
        this.fuelTypes = fuelTypes;
    }

    public List<String> getGearboxTypes() {
        return gearboxTypes;
    }

    public void setGearboxTypes(List<String> gearboxTypes) {
        this.gearboxTypes = gearboxTypes;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }
}
