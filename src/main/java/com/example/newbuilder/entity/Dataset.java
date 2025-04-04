package com.example.newbuilder.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
// import org.springframework.format.annotation.DateTimeFormat;
// import com.fasterxml.jackson.annotation.JsonFormat;

//import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
//import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@ToString
@Table(name = "datasets")
public class Dataset {
    @Column(name = "id")
    private String id;
    // do not change the variable name from dataset_id to datasetId as this is the expected camal case for reposotory
    // JPA expects in camel case if we give snake case it will not work.................
    //@Column(name = "dataset_id")
    @Column(name = "dataset_id", unique = true, nullable = false)
    // @Column(name = "dataset_id", unique = true, nullable = false)
    @Id  
    private String datasetId;
    

    // public String getDataset_id() {
    //     return dataset_id;
    // }
    // public void setDataset_id(String dataset_id) {
    //     this.dataset_id = dataset_id;
    // }
    @Column(name = "type")
    private String type;
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private String status;
    @Column(name = "tags", columnDefinition = "text[]")
    private String[] tags;
    @Column(name = "data_version")
    private int dataVersion;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_by")
    private String updatedBy;
    

    
    // private DateTimeFormatter created_date;
    @Column(name = "created_date")
    @JdbcTypeCode(SqlTypes.LOCAL_DATE_TIME)
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    @JdbcTypeCode(SqlTypes.LOCAL_DATE)
    private LocalDate updatedDate;
  
    @Column(name = "published_date")
    @JdbcTypeCode(SqlTypes.LOCAL_DATE_TIME)
    private LocalDateTime publishedDate;




    @Column(name = "validation_config", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> validationConfig; 
    @Column(name = "extraction_config", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> extractionConfig;
    @Column(name = "dedup_config", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> dedupConfig;
    @Column(name = "data_schema", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> dataSchema;
    @Column(name = "denorm_config", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> denormConfig;
    @Column(name = "router_config", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> routerConfig;
    @Column(name = "dataset_config", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> datasetConfig;
    

  
}
