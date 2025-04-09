package com.example.newbuilder.DTO;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class StandardRequestTemplate<T> {

    private String id;
    private String ver;
    private String ts;
    private Map<String, String> params;
    private T result;

    public static <T> StandardRequestTemplate<T> success(String id_path, T result) {
        return new StandardRequestTemplate<>(
            id_path,
            "v1",
            LocalDateTime.now().toString(),
            Map.of("msgid", UUID.randomUUID().toString()),            
            result
        );
    }
    
    
}
