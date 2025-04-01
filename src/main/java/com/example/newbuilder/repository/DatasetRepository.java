package com.example.newbuilder.repository;

import com.example.newbuilder.entity.Dataset;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DatasetRepository extends JpaRepository<Dataset, String> {
    Optional<Dataset> findByDatasetId(String datasetId);
    void deleteByDatasetId(String datasetId);
}
