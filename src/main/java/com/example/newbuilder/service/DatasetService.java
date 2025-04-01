package com.example.newbuilder.service;

import com.example.newbuilder.entity.Dataset;
import com.example.newbuilder.repository.DatasetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DatasetService {
    @Autowired
    private DatasetRepository repository;

    public Dataset createDataset(Dataset dataset) {
        System.out.println("Data set services\n"+dataset.toString());
        return repository.save(dataset);
    }

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
}
