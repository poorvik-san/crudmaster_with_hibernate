package com.example.newbuilder.DTO;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
public class DataSetRequest {
    // do not change the variable name from dataset_id to datasetId
    // because the request body is coming from the frontend with the name dataset_id
    // and the request body is in JSON format...........................
    private String datasetId;
    private String type;
    private String name;
    private String status;
    private String[] tags;
    private int dataVersion;
    private String createdBy;
    private String updatedBy;
    private Map<String, Object> validationConfig;
    private Map<String, Object> extractionConfig;
    private Map<String, Object> dedupConfig;
    private Map<String, Object> dataSchema;
    private Map<String, Object> denormConfig;
    private Map<String, Object> routerConfig;
    private Map<String, Object> datasetConfig;
    
}
