## The new changes ...


### POST request.

``` JSON
{
    
    "datasetId": "111",
    "type": "dataset",
    "name": "observations-transformed",
    "validationConfig": {
        "validate": true,
        "mode": "Strict",
        "validation_mode": "Strict"
    },
    "extractionConfig": {
        "is_batch_event": true,
        "extraction_key": "events",
        "dedup_config": {
            "drop_duplicates": true,
            "dedup_key": "id",
            "dedup_period": 720
        },
        "batchId": "id"
    },
    "dedupConfig": {
        "drop_duplicates": true,
        "dedup_key": "id",
        "dedup_period": 720
    },
    "dataSchema": {
        "$schema": "https://json-schema.org/draft/2020-12/schema",
        "title": "Canonical Observations",
        "description": "A canonical observation",
        "type": "object",
        "properties": {
            "obsCode": {
                "type": "string"
            },
            "codeComponents": {
                "type": "array",
                "items": {
                    "type": "object",
                    "properties": {
                        "componentCode": {
                            "type": "string"
                        },
                        "componentType": {
                            "type": "string",
                            "enum": [
                                "AGG_TIME_WINDOW",
                                "AGG_METHOD",
                                "PARAMETER",
                                "FEATURE_OF_INTEREST",
                                "OBS_PROPERTY",
                                "SAMPLING_STRATEGY",
                                "OBS_METHOD",
                                "METADATA",
                                "METADATA_DEVICE",
                                "DATA_QUALITY",
                                "EVENT",
                                "FOI_CONTEXT"
                            ]
                        },
                        "selector": {
                            "type": "string"
                        },
                        "value": {
                            "type": "string"
                        },
                        "valueUoM": {
                            "type": "string"
                        }
                    }
                }
            },
        }
        truncated 
    }
}


``` 


###  post response response 

```JSON
{
"id_path": "api.datasets.create",
"ver": "v2",
"ts": "2025-04-07T11:17:24.824034+05:30[Asia/Kolkata]",
"params": {
    "status": "SUCCESS"
},
"responseCode": "CREATED",
"result": {
    "id": "5199909c-19c1-485d-bfee-eb349d3d9cbc",
    "datasetId": "111",
    "type": "dataset",
    "name": "observations-transformed",
    "status": "Live",
    "tags": [
        "tag1",
        "tag2"
    ],
    "dataVersion": 1,
    "createdBy": "SYSTEM",
    "updatedBy": "SYSTEM",
    "createdDate": "2025-04-07T11:17:24.726909",
    "updatedDate": "2025-04-07",
    "publishedDate": "2025-04-07T11:17:24.726957",
    "validationConfig": {
        "validate": true,
        "mode": "Strict",
        "validation_mode": "Strict"
    },
    "extractionConfig": {
        "is_batch_event": true,
        "extraction_key": "events",
        "dedup_config": {
            "drop_duplicates": true,
            "dedup_key": "id",
            "dedup_period": 720
        },
        "batchId": "id"
    },
    "dedupConfig": {
        "data_key": "",
        "timestamp_key": "phenTime",
        "exclude_fields": [],
        "entry_topic": "local.ingest",
        "redis_db_host": "192.168.106.2",
        "redis_db_port": 6379,
        "index_data": true,
        "redis_db": 0
    },
    "dataSchema": {
        "$schema": "https://json-schema.org/draft/2020-12/schema",
        "title": "Canonical Observations",
        "description": "A canonical observation",
        "type": "object",
        "properties": {
            "obsCode": {
                "type": "string"
            },
            "codeComponents": {
                "type": "array",
                "items": {
                    "type": "object",
                    "properties": {
                        "componentCode": {
                            "type": "string"
                        },
                        "componentType": {
                            "type": "string",
                            "enum": [
                                "AGG_TIME_WINDOW",
                                "AGG_METHOD",
                                "PARAMETER",
                                "FEATURE_OF_INTEREST",
                                "OBS_PROPERTY",
                                "SAMPLING_STRATEGY",
                                "OBS_METHOD",
                                "METADATA",
                                "METADATA_DEVICE",
                                "DATA_QUALITY",
                                "EVENT",
                                "FOI_CONTEXT"
                            ]
                        },
                        "selector": {
                            "type": "string"
                        },
                        "value": {
                            "type": "string"
                        },
                        "valueUoM": {
                            "type": "string"
                        }
                    }
                }
            },
           

```


### when already exists data is pushed -->

``` JSON
{
"id_path": "api.datasets.duplicate",
"ver": "v2",
"ts": "2025-04-07T11:20:45.310902+05:30[Asia/Kolkata]",
"params": {
    "status": "FAILED"
},
"responseCode": "CONFLICT",
"result": "Dataset with ID 111 already exists"
}
```


### Patch 
    
Api end point --> http://localhost:8080/v1/dataset/111

request body -->
``` JSON
{
"type": "jujust patching test",
"name": "ss"
}
```

response 
``` JSON
{
"id_path": "api.datasets.update",
"ver": "v2",
"ts": "2025-04-07T11:22:20.669936+05:30[Asia/Kolkata]",
"params": {
    "status": "SUCCESS"
},
"responseCode": "OK",
"result": {
    "id": "5199909c-19c1-485d-bfee-eb349d3d9cbc",
    "datasetId": "111",
    "type": "jujust patching test",
    "name": "ss",
    "status": "Live",
    "tags": [
        "tag1",
        "tag2"
    ],
    "dataVersion": 3,
    "createdBy": "SYSTEM",
    "updatedBy": "SYSTEM",

    truncated the reponse 
}}
```

### patching non existing data manuplation 
http://localhost:8080/v1/dataset/9999
```JSON
{
   "type": "jujust patching test",
   "name": "ss"
}
```
 response 
 ``` JSON

 {
    "id_path": "api.datasets.error",
    "ver": "v2",
    "ts": "2025-04-07T11:55:11.539493+05:30[Asia/Kolkata]",
    "params": {
        "status": "FAILED"
    },
    "responseCode": "INTERNAL_SERVER_ERROR",
    "result": "Dataset with ID 9999 not found"
}

 ```


 ### Deleting 
 http://localhost:8080/v1/dataset/333

 response 
 ```JSON
 {
    "id_path": "api.datasets.delete",
    "ver": "v2",
    "ts": "2025-04-07T11:56:30.320526+05:30[Asia/Kolkata]",
    "params": {
        "status": "SUCCESS"
    },
    "responseCode": "OK",
    "result": "Dataset deleted successfully."
}

 ```

 ### If no data is present 

 ``` JSON 

{
    "id_path": "api.datasets.error",
    "ver": "v2",
    "ts": "2025-04-07T11:57:46.114912+05:30[Asia/Kolkata]",
    "params": {
        "status": "FAILED"
    },
    "responseCode": "INTERNAL_SERVER_ERROR",
    "result": "Dataset with ID 333 not found for deletion"
}
 ```


 ### Get request

 http://localhost:8080/v1/dataset/111


 Response 

 ``` JSON 

{
    "id_path": "api.datasets.get",
    "ver": "v2",
    "ts": "2025-04-07T11:58:30.676357+05:30[Asia/Kolkata]",
    "params": {
        "status": "SUCCESS"
    },
    "responseCode": "OK",
    "result": {
        "id": "5199909c-19c1-485d-bfee-eb349d3d9cbc",
        "datasetId": "111",
        "type": "jujust patching test",
        "name": "ss",
        "status": "Live",
        "tags": [
            "tag1",
            "tag2"
        ],
        "dataVersion": 3,
        "createdBy": "SYSTEM",
        "updatedBy": "SYSTEM",
        "createdDate": "2025-04-07T11:17:24.726909",
        "updatedDate": "2025-04-07",
        "publishedDate": "2025-04-07T11:17:24.726957",
        "validationConfig": {
            "mode": "Strict",
            "validate": true,
            "validation_mode": "Strict"
        },
        "extractionConfig": {
            "batchId": "id",
            "dedup_config": {
                "dedup_key": "id",
                "dedup_period": 720,
                "drop_duplicates": true
            },
            "extraction_key": "events",
            "is_batch_event": true
        },
        "dedupConfig": null,
        "dataSchema": {
            "type": "object",
            "title": "Canonical Observations",
            "$schema": "https://json-schema.org/draft/2020-12/schema",
            "required": [
                "id",
                "parentCollectionRef",
                "integrationAccountRef",
                "obsCode",
                "phenTime",
                "value"
            ],
            "properties": {
                "id": {
                    "type": "string"
                },
                "xMax": {
                    "type": "number"
                },
                "xMin": {
                    "type": "number"
                },
                "yMax": {
                    "type": "number"
                },
                "yMin": {
                    "type": "number"
                },
                "value": {
                    "type": "string"
                },
                "obsCode": {
                    "type": "string"
                },
                "assetRef": {
                    "type": "string"
                },
                "modified": {
                    "type": "number"
                },
                "phenTime": {
                    "type": "string",
                    "format": "date-time",
                    "suggestions": [
                        {
                            "advice": "The System can index all data on this column",
                            "message": "The Property 'phenTime' appears to be 'date-time' format type.",
                            "severity": "LOW",
                            "resolutionType": "INDEX"
                        }
                    ]
                },
                "valueUoM": {
                    "type": "string"
                },
                "phenEndTime": {
                    "type": "string",
                    "format": "date-time",
                    "suggestions": [
                        {
                            "advice": "The System can index all data on this column",
                            "message": "The Property 'phenEndTime' appears to be 'date-time' format type.",
                            "severity": "LOW",
                            "resolutionType": "INDEX"
                        }
                    ]
                },
                "spatialExtent": {
                    "type": "string"
                },
                "codeComponents": {
                    "type": "array",
                    "items": {
                        "type": "object",
                        "properties": {
                            "value": {
                                "type": "string"
                            },
                            "selector": {
                                "type": "string"
                            },
                            "valueUoM": {
                                "type": "string"
                            },
                            "componentCode": {
                                "type": "string"
                            },
                            "componentType": {
                                "enum": [
                                    "AGG_TIME_WINDOW",
                                    "AGG_METHOD",
                                    "PARAMETER",
                                    "FEATURE_OF_INTEREST",
                                    "OBS_PROPERTY",
                                    "SAMPLING_STRATEGY",
                                    "OBS_METHOD",
                                    "METADATA",
                                    "METADATA_DEVICE",
                                    "DATA_QUALITY",
                                    "EVENT",
                                    "FOI_CONTEXT"
                                ],
                                "type": "string"
                            }
                        }
                    }
                },
                "parentCollectionRef": {
                    "type": "string"
                },
                "integrationAccountRef": {
                    "type": "string"
                }
            },
            "description": "A canonical observation"
        },
        "denormConfig": {
            "denorm_fields": [
                {
                    "redis_db": 3,
                    "denorm_key": "assetRef",
                    "denorm_out_field": "assetMeta"
                },
                {
                    "redis_db": 4,
                    "denorm_key": "integrationAccountRef",
                    "denorm_out_field": "providerMeta"
                }
            ],
            "redis_db_host": "192.168.106.2",
            "redis_db_port": 6379
        },
        "routerConfig": {
            "topic": "observations-transformed"
        },
        "datasetConfig": {
            "data_key": "",
            "redis_db": 0,
            "index_data": true,
            "entry_topic": "local.ingest",
            "redis_db_host": "192.168.106.2",
            "redis_db_port": 6379,
            "timestamp_key": "phenTime",
            "exclude_fields": []
        }
    }
}
 ```

 If no data found 

 ```JSON 

 {
    "id_path": "api.datasets.error",
    "ver": "v2",
    "ts": "2025-04-07T11:59:23.465646+05:30[Asia/Kolkata]",
    "params": {
        "status": "FAILED"
    },
    "responseCode": "INTERNAL_SERVER_ERROR",
    "result": "Dataset with ID 222 not found"
}

```
