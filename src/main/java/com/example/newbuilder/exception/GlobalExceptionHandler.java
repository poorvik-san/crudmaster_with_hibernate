package com.example.newbuilder.exception;

import com.example.newbuilder.DTO.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateDatasetException.class)
    public ResponseEntity<ApiResponse<String>> handleDuplicateDatasetException(DuplicateDatasetException ex) {
        ApiResponse<String> response = new ApiResponse<>(
                "api.datasets.duplicate",
                "v2",
                ZonedDateTime.now().toString(),
                Map.of("status", "FAILED"),
                HttpStatus.CONFLICT.name(),
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<String>> handleRuntimeException(RuntimeException ex) {
        ApiResponse<String> response = new ApiResponse<>(
                "api.datasets.error",
                "v2",
                ZonedDateTime.now().toString(),
                Map.of("status", "FAILED"),
                HttpStatus.INTERNAL_SERVER_ERROR.name(),
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
