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

    /*
     * 
     * {
  "id": "api.datasets.create",
  "ver": "v2",
  "ts": "2024-07-15T18:44:08+05:30",
  "params": {
    "status": "SUCCESS",
    "msgid": "4a7f14c3-d61e-4d4f-be78-181834eeff6d",
    "resmsgid": "276c042c-0f23-4b26-9b10-6fe48bbc2d3a"
  },
  "responseCode": "OK",
  "result": {
    "id": "telemetry_record-t4",
    "version_key": "1721049248930"
  }
}
     */
}