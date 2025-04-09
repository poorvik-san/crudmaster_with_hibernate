package com.example.newbuilder.controller;
//import com.example.newbuilder.DTO.ApiResponse;
import com.example.newbuilder.DTO.ApiResponse2;
import com.example.newbuilder.DTO.DataSetRequest;
import com.example.newbuilder.DTO.DataSetResponse;
import com.example.newbuilder.DTO.DataSetResponse2;
import com.example.newbuilder.entity.Dataset;
import com.example.newbuilder.service.DatasetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/v1/dataset")
public class DatasetController {
    @Autowired
    private DatasetService service;
    @PostMapping("/create")
    public ResponseEntity<ApiResponse2<DataSetResponse2>> createDataset(@RequestBody DataSetRequest dataset) {
        System.out.println(dataset.getDatasetId());
        DataSetResponse2 response = service.createDataset(dataset);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse2.success("api.datasets.create", response, HttpStatus.CREATED,response.getId()));
    }
    @GetMapping("/findall")
    public ResponseEntity<ApiResponse2<List<DataSetResponse>>> getAllDatasets() {
        List<DataSetResponse> datasets = service.findAllDatasets();
        return ResponseEntity.ok(ApiResponse2.success2("api.datasets.findall", datasets, HttpStatus.OK));
    }
    @GetMapping("/{datasetId}")
    public ResponseEntity<ApiResponse2<Dataset>> getDataset(@PathVariable String datasetId) {
        Dataset dataset = service.getDatasetById(datasetId);
        return ResponseEntity.ok(ApiResponse2.success("api.datasets.get", dataset, HttpStatus.OK,dataset.getId()));
    }
    @PatchMapping("/{datasetId}")
    public ResponseEntity<ApiResponse2<Dataset>> updateDataset(@PathVariable String datasetId, @RequestBody Dataset dataset) {
        Dataset updatedDataset = service.updateDataset(datasetId, dataset);
        return ResponseEntity.ok(ApiResponse2.success("api.datasets.update", updatedDataset, HttpStatus.OK,updatedDataset.getId()));
    }
    @DeleteMapping("/{datasetId}")
    public ResponseEntity<ApiResponse2<DataSetResponse2>> deleteDataset(@PathVariable String datasetId) {
        DataSetResponse2 dataset = service.deleteDataset(datasetId);
        return ResponseEntity.ok(ApiResponse2.success("api.datasets.delete", dataset, HttpStatus.OK,dataset.getId()));
    }
}