package com.example.newbuilder.DTO;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataSetRequest {
    private String datasetId;
    private String type;
    private String name;
    private String status;
    private String[] tags;
    private int data_version;
    private String created_by;
    private String updated_by;
    private Map<String, Object> validationConfig;
    private Map<String, Object> extraction_config;
    private Map<String, Object> dedup_config;
    private Map<String, Object> data_schema;
    private Map<String, Object> denorm_config;
    private Map<String, Object> router_config;
    private Map<String, Object> dataset_config;
}
