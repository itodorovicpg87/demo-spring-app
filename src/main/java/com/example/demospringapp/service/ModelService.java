package com.example.demospringapp.service;

import com.example.demospringapp.domain.Model;
import com.example.demospringapp.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {
    private final ModelRepository modelRepository;

    @Autowired
    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }

    public Model getModelById(Long id) {
        return modelRepository.findById(id).orElse(null);
    }

    public Model createModel(Model model) {
        return modelRepository.save(model);
    }

    public Model updateModel(Long id, Model model) {
        if (modelRepository.existsById(id)) {
            model.setId(id);
            return modelRepository.save(model);
        }
        return null;
    }

    public void deleteModel(Long id) {
        modelRepository.deleteById(id);
    }

    // Implement service methods for CRUD operations
}

