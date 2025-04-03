package com.example.newbuilder.controller;

import com.example.newbuilder.DTO.DataSetRequest;
import com.example.newbuilder.DTO.DataSetResponse;
import com.example.newbuilder.entity.Dataset;
import com.example.newbuilder.service.DatasetService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/dataset")
public class DatasetController {
    @Autowired
    private DatasetService service;

    @PostMapping
    public DataSetResponse createDataset(@RequestBody DataSetRequest dataset) {
        // System.out.println("----------------------------------");
        // ObjectMapper ompr= new ObjectMapper();
        // try {
        //     String out  = ompr.writeValueAsString(dataset);
        //     System.out.println(out);
        // } catch (JsonProcessingException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }//.orElseThrow( new JsonProcessingException("issue with conversoin"));
        // System.out.println("----------------------------------");
        
        System.out.println(dataset);
        // System.out.println("Data set controller"+dataset.toString());
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
