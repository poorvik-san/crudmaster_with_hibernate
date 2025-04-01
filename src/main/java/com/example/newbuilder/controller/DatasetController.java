package com.example.newbuilder.controller;

import com.example.newbuilder.entity.Dataset;
import com.example.newbuilder.service.DatasetService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/dataset")
public class DatasetController {
    @Autowired
    private DatasetService service;

    @PostMapping
    public Dataset createDataset(@RequestBody Dataset dataset) {
        System.out.println("Data set controller"+dataset.toString());
        return service.createDataset(dataset);
    }

    @GetMapping("/{datasetId}")
    public Dataset getDataset(@PathVariable String datasetId) {
        return service.getDataset(datasetId).orElseThrow(() -> new RuntimeException("Dataset not found"));
    }

    @PatchMapping("/{datasetId}")
    public Dataset updateDataset(@PathVariable String datasetId, @RequestBody Dataset dataset) {
        return service.updateDataset(datasetId, dataset);
    }

    @DeleteMapping("/{datasetId}")
    public void deleteDataset(@PathVariable String datasetId) {
        service.deleteDataset(datasetId);
    }
   
    
}
