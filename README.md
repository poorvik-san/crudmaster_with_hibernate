
These are the requests and responses for the simulation of RESTful API services using Spring Boot.

---

### **POST**  
**URL:** `http://127.0.0.1:8080/v1/dataset/create`  

**Request:**
```json
{
  "datasetId": "666",
  "type": "dsfdsffsaf",
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
<<<TRUNCATED>>>
  }
}
```

**Successful Response:**
```json
{
  "id": "api.datasets.create",
  "ver": "v1",
  "ts": "2025-04-09T11:20:49.992233",
  "params": {
    "msgid": "ef64f976-9142-41b1-ac70-97983aeaecba",
    "resmsgid": "23d4df0e-9b99-4da3-97f5-5539e76bdc8e",
    "status": "SUCCESS"
  },
  "responseCode": "OK",
  "result": {
    "id": "ef64f976-9142-41b1-ac70-97983aeaecba",
    "datasetId": "666",
    "type": "dsfdsffsaf",
    "dataVersion": 1,
    "message": "Dataset created successfully",
    "ver": "v1"
  }
}
```

**If dataset already exists:**
```json
{
  "id": "api.datasets.duplicate",
  "ver": "v1",
  "ts": "2025-04-09T11:21:27.367834",
  "params": {
    "status": "FAILED",
    "resmsgid": "a26cf7f6-cdac-4a1a-894c-31be0d5f899f"
  },
  "responseCode": "OK",
  "result": "Dataset with ID 666 already exists"
}
```

**If required fields are missing:**
```json
{
  "id": "api.datasets.error",
  "ver": "v1",
  "ts": "2025-04-09T11:22:24.289416",
  "params": {
    "status": "FAILED",
    "resmsgid": "2c677193-a5ee-4fe0-ba82-95ad78a8edf6"
  },
  "responseCode": "OK",
  "result": "The given id must not be null"
}
```

---

### **GET**  
**URL:** `http://localhost:8080/v1/dataset/666`  

**Response:**
```json
{
  "id": "api.datasets.get",
  "ver": "v1",
  "ts": "2025-04-09T11:23:00.540652",
  "params": {
    "msgid": "ef64f976-9142-41b1-ac70-97983aeaecba",
    "resmsgid": "08d08e59-0b5b-4b52-b1ec-6d100b1c3ae4",
    "status": "SUCCESS"
  },
  "responseCode": "OK",
  "result": {
    "id": "ef64f976-9142-41b1-ac70-97983aeaecba",
    "datasetId": "666",
    "type": "dsfdsffsaf",
    "name": "observations-transformed",
    "status": "Live",
    "tags": [
      "tag1",
      "tag2"
    ]
<<<TRUNCATED>>>
  }
}
```

**If dataset not found:**
```json
{
  "id": "api.datasets.error",
  "ver": "v1",
  "ts": "2025-04-09T11:23:22.985722",
  "params": {
    "status": "FAILED",
    "resmsgid": "e1da0bfe-78b5-456b-a81d-60d22817b924"
  },
  "responseCode": "OK",
  "result": "Dataset with ID 321342 not found"
}
```

---

### **GET All**  
**URL:** `http://localhost:8080/v1/dataset/findall`  

**Response:**
```json
{
  "id": "api.datasets.findall",
  "ver": "v1",
  "ts": "2025-04-09T11:23:56.336131",
  "params": {
    "status": "SUCCESS",
    "resmsgid": "6965de88-7272-433a-8bc0-d4cb5669af51"
  },
  "responseCode": "OK",
  "result": [
    {
      "id": "c72410d0-5546-47ba-97b8-b078567e9a2a",
      "datasetId": "101",
      "type": "dataset",
      "name": "observations-transformed",
      "status": "Live",
      "tags": [
        "tag1",
        "tag2"
      ]
    }
<<<TRUNCATED>>>
  ]
}
```

---

### **PATCH**  
**URL:** `http://localhost:8080/v1/dataset/444`  

**Request:**
```json
{
  "type": "jujust patching test",
  "name": "ss"
}
```

**Response:**
```json
{
  "id": "api.datasets.update",
  "ver": "v1",
  "ts": "2025-04-09T11:24:30.376515",
  "params": {
    "msgid": "ee6649b7-b0cd-466b-a794-c82f502bd1c3",
    "resmsgid": "50e79877-bb34-4eb2-a635-b11a30b4449d",
    "status": "SUCCESS"
  },
  "responseCode": "OK",
  "result": {
    "id": "ee6649b7-b0cd-466b-a794-c82f502bd1c3",
    "datasetId": "444",
    "type": "jujust patching test",
    "name": "ss"

<<<TRUNCATED>>>
  }
}
```

---

### **DELETE**  
**URL:** `http://localhost:8080/v1/dataset/111`  

**Successful Response:**
```json
{
  "id": "api.datasets.delete",
  "ver": "v1",
  "ts": "2025-04-09T11:25:50.836595",
  "params": {
    "msgid": "ed982faf-3f34-435f-ad21-751d12486545",
    "resmsgid": "1f727878-0d40-478d-8b95-99c07d660444",
    "status": "SUCCESS"
  },
  "responseCode": "OK",
  "result": {
    "id": "ed982faf-3f34-435f-ad21-751d12486545",
    "datasetId": "111",
    "type": "dsfdsffsaf",
    "dataVersion": 1,
    "message": "Dataset deleted successfully",
    "ver": "v1"
  }
}
```

**If dataset not found:**
```json
{
  "id": "api.datasets.error",
  "ver": "v1",
  "ts": "2025-04-09T11:26:16.590747",
  "params": {
    "status": "FAILED",
    "resmsgid": "8f3e596e-8e21-4df4-9326-3ce7c29c7d2f"
  },
  "responseCode": "OK",
  "result": "Dataset with ID 111 not found for deletion"
}
```


