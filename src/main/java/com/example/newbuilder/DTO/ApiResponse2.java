package com.example.newbuilder.DTO;
import java.time.LocalDateTime;
import java.util.Map;
import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;
//import com.example.newbuilder.DTO.DataSetResponse;
@Getter
@Setter
@AllArgsConstructor
public class ApiResponse2<T> {
    private String id;
    private String ver;
    private String ts;
    private Map<String, String> params;
    private String responseCode;
    private T result;
    public static <T> ApiResponse2<T> success(String id_path, T result, HttpStatus status,String msgid) {
        return new ApiResponse2<>(
            id_path,
            "v1",
            LocalDateTime.now().toString(),
            Map.of(
                "status","SUCCESS",
                
                "resmsgid",UUID.randomUUID().toString(),
                "msgid",msgid
                
                ),
            HttpStatus.OK.name(),
                result
            );
        }
        public static <T> ApiResponse2<T> success2(String id_path, T result, HttpStatus status) {
            return new ApiResponse2<>(
                id_path,
                "v1",
                LocalDateTime.now().toString(),
                Map.of(
                    "status","SUCCESS",
                    "resmsgid",UUID.randomUUID().toString()
                    
                    ),
                HttpStatus.OK.name(),
                result
            );
        }    
        public static <T> ApiResponse2<T> failure(String id_path, T result, HttpStatus status,String errorstatus) {
            return new ApiResponse2<>(
                id_path,
                "v1",
                LocalDateTime.now().toString(),
                Map.of(
                    "status",errorstatus,
                    "resmsgid",UUID.randomUUID().toString()
                    
                    ),
                HttpStatus.OK.name(),
                result
            );
        }    
            

}