package com.example.newbuilder.service;

import com.example.newbuilder.DTO.*;
import com.example.newbuilder.entity.Dataset;
import com.example.newbuilder.repository.DatasetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class DatasetService {
    @Autowired
    private DatasetRepository repository;

    // public Dataset createDataset(Dataset dataset) {
    //     System.out.println("Data set services\n"+dataset.toString());
    //     return repository.save(dataset);
    // }

    public Optional<Dataset> getDataset(String datasetId) {
        return repository.findByDatasetId(datasetId);
    }

    @Transactional
    public Dataset updateDataset(String datasetId, Dataset newData) {
        return repository.findByDatasetId(datasetId).map(dataset -> {
            if (newData.getType() != null) 
                dataset.setType(newData.getType());
            if (newData.getName() != null) 
                dataset.setName(newData.getName());
            return repository.save(dataset);
        }).orElseThrow(() -> new RuntimeException("Dataset not found"));
    }
    @Transactional
    public void deleteDataset(String datasetId) {
        repository.deleteByDatasetId(datasetId);
    }

    // @Autowired
    // private DatasetRepository datasetRepository;

    public DataSetResponse createDataset(DataSetRequest datasetRequest) {
        Dataset dataset = new Dataset();
        dataset.setId(UUID.randomUUID().toString());
        dataset.setDatasetId(datasetRequest.getDatasetId());
        dataset.setType(datasetRequest.getType());
        dataset.setName(datasetRequest.getName());
        dataset.setStatus(datasetRequest.getStatus());
        dataset.setTags(datasetRequest.getTags());
        dataset.setData_version(datasetRequest.getData_version());
        dataset.setCreated_by(datasetRequest.getCreated_by());
        dataset.setUpdated_by(datasetRequest.getUpdated_by());
        dataset.setValidationConfig(datasetRequest.getValidationConfig());
        dataset.setExtraction_config(datasetRequest.getExtraction_config());
        dataset.setDedup_config(datasetRequest.getDedup_config());
        dataset.setData_schema(datasetRequest.getData_schema());
        dataset.setDenorm_config(datasetRequest.getDenorm_config());
        dataset.setRouter_config(datasetRequest.getRouter_config());
        dataset.setDataset_config(datasetRequest.getDataset_config());

        // Auto-generate dates
        dataset.setCreated_date(LocalDateTime.now());
        dataset.setUpdated_date(LocalDateTime.now().toLocalDate());
        dataset.setPublished_date(LocalDateTime.now());

        dataset = repository.save(dataset);

        return mapToResponse(dataset);
    }

    private DataSetResponse mapToResponse(Dataset dataset) {
        DataSetResponse datasetResponse = new DataSetResponse();
        datasetResponse.setId(dataset.getId());
        datasetResponse.setDatasetId(dataset.getDatasetId());
        datasetResponse.setType(dataset.getType());
        datasetResponse.setName(dataset.getName());
        datasetResponse.setStatus(dataset.getStatus());
        datasetResponse.setTags(dataset.getTags());
        datasetResponse.setData_version(dataset.getData_version());
        datasetResponse.setCreated_by(dataset.getCreated_by());
        datasetResponse.setUpdated_by(dataset.getUpdated_by());
        datasetResponse.setCreated_date(dataset.getCreated_date());
        datasetResponse.setUpdated_date(dataset.getUpdated_date());
        datasetResponse.setPublished_date(dataset.getPublished_date());
        datasetResponse.setValidationConfig(dataset.getValidationConfig());
        datasetResponse.setExtraction_config(dataset.getExtraction_config());
        datasetResponse.setDedup_config(dataset.getDedup_config());
        datasetResponse.setData_schema(dataset.getData_schema());
        datasetResponse.setDenorm_config(dataset.getDenorm_config());
        datasetResponse.setRouter_config(dataset.getRouter_config());
        datasetResponse.setDataset_config(dataset.getDataset_config());
        return datasetResponse;
    }
}
