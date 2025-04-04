package com.example.newbuilder.controller;
import com.example.newbuilder.DTO.ApiResponse;
import com.example.newbuilder.DTO.DataSetRequest;
import com.example.newbuilder.DTO.DataSetResponse;
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
    public ResponseEntity<ApiResponse<DataSetResponse>> createDataset(@RequestBody DataSetRequest dataset) {
        System.out.println(dataset.getDatasetId());
        DataSetResponse response = service.createDataset(dataset);
        //String validate_id=response.getDataset_id();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("api.datasets.create", response, HttpStatus.CREATED));
    }
    @GetMapping("/findall")
    public ResponseEntity<ApiResponse<List<DataSetResponse>>> getAllDatasets() {
        List<DataSetResponse> datasets = service.findAllDatasets();
        return ResponseEntity.ok(ApiResponse.success("api.datasets.findall", datasets, HttpStatus.OK));
    }
    @GetMapping("/{datasetId}")
    public ResponseEntity<ApiResponse<Dataset>> getDataset(@PathVariable String datasetId) {
        Dataset dataset = service.getDatasetById(datasetId);
        return ResponseEntity.ok(ApiResponse.success("api.datasets.get", dataset, HttpStatus.OK));
    }
    @PatchMapping("/{datasetId}")
    public ResponseEntity<ApiResponse<Dataset>> updateDataset(@PathVariable String datasetId, @RequestBody Dataset dataset) {
        Dataset updatedDataset = service.updateDataset(datasetId, dataset);
        return ResponseEntity.ok(ApiResponse.success("api.datasets.update", updatedDataset, HttpStatus.OK));
    }
    @DeleteMapping("/{datasetId}")
    public ResponseEntity<ApiResponse<String>> deleteDataset(@PathVariable String datasetId) {
        service.deleteDataset(datasetId);
        return ResponseEntity.ok(ApiResponse.success("api.datasets.delete", "Dataset deleted successfully.", HttpStatus.OK));
    }
}