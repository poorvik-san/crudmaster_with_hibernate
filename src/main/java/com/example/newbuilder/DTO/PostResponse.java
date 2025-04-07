package com.example.newbuilder.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class PostResponse {
     private String id;
    // do not change the variable name from dataset_id to datasetId
    private String datasetId;
    private String type;
    private String name;
    private String status;

}
