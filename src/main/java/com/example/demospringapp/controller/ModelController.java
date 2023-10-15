package com.example.demospringapp.controller;

import com.example.demospringapp.domain.Model;
import com.example.demospringapp.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/models")
public class ModelController {
    private final ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping
    public List<Model> getAllModels() {
        return modelService.getAllModels();
    }

    @GetMapping("/{id}")
    public Model getModelById(@PathVariable Long id) {
        return modelService.getModelById(id);
    }

    @PostMapping
    public Model createModel(@RequestBody Model model) {
        return modelService.createModel(model);
    }

    @PutMapping("/{id}")
    public Model updateModel(@PathVariable Long id, @RequestBody Model model) {
        return modelService.updateModel(id, model);
    }

    @DeleteMapping("/{id}")
    public void deleteModel(@PathVariable Long id) {
        modelService.deleteModel(id);
    }
}
