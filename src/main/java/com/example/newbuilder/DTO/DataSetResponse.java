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
    private String datasetId;
    private String type;
    private String name;
    private String status;
    private String[] tags;
    private int data_version;
    private String created_by;
    private String updated_by;
    private LocalDateTime created_date;
    private LocalDate updated_date;
    private LocalDateTime published_date;
    private Map<String, Object> validationConfig;
    private Map<String, Object> extraction_config;
    private Map<String, Object> dedup_config;
    private Map<String, Object> data_schema;
    private Map<String, Object> denorm_config;
    private Map<String, Object> router_config;
    private Map<String, Object> dataset_config;
}