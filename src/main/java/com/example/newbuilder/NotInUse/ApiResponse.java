package com.example.newbuilder.NotInUse;
// package com.example.newbuilder.DTO;
// import java.time.LocalDateTime;
// import java.util.Map;
// import org.springframework.http.HttpStatus;
// import lombok.AllArgsConstructor;
// import lombok.Getter;
// import lombok.Setter;
// @Getter
// @Setter
// @AllArgsConstructor
// public class ApiResponse<T> {
//     private String id;
//     private String ver;
//     private String ts;
//     private Map<String, String> params;
//     private String responseCode;
//     private T result;
//     public static <T> ApiResponse<T> success(String id_path, T result, HttpStatus status) {
//         return new ApiResponse<>(
//             id_path,
//             "v1",
//             LocalDateTime.now().toString(),
//             Map.of("status", "SUCCESS"),
//             status.name(),
//             result
//         );
//     }
// }