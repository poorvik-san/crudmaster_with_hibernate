package com.example.newbuilder.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;

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
    @Id
    private String id;
    //@Column(name = "dataset_id")
    private String datasetId;
    

    private String type;
    private String name;
    private String status;
    private String[] tags;
    private int data_version;
    private String created_by;
    private String updated_by;
    

    
    // private DateTimeFormatter created_date;
    @JdbcTypeCode(SqlTypes.LOCAL_DATE_TIME)
    private LocalDateTime created_date;

    @JdbcTypeCode(SqlTypes.LOCAL_DATE)
    private LocalDate updated_date;
  
    @JdbcTypeCode(SqlTypes.LOCAL_DATE_TIME)
    private LocalDateTime published_date;




    @Column(name = "validation_config", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private String validation_config; 
    @Column(name = "extraction_config", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private String extraction_config;
    @Column(name = "dedup_config", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private String dedup_config;
    @Column(name = "data_schema", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private String data_schema;
    @Column(name = "denorm_config", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private String denorm_config;
    @Column(name = "router_config", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private String router_config;
    @Column(name = "dataset_config", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private String dataset_config;
    

  
}
