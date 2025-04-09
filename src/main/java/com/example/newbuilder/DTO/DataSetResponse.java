package com.example.newbuilder.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataSetResponse {
    
    private String id;
    // do not change the variable name from dataset_id to datasetId
    private String datasetId;
    private String type;
    private String name;
    private String status;
    private String[] tags;
    private int dataVersion;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createdDate;
    private LocalDate updatedDate;
    private LocalDateTime publishedDate;
    private Map<String, Object> validationConfig;
    private Map<String, Object> extractionConfig;
    private Map<String, Object> dedupConfig;
    private Map<String, Object> dataSchema;
    private Map<String, Object> denormConfig;
    private Map<String, Object> routerConfig;
    private Map<String, Object> datasetConfig;

    // adding according to standaed request and reponse
    private String ver;

}