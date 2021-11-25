package pl.gozderapatryk.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponseDto {
    private LocalDateTime timestamp;
    private int statusCode;
    private String message;
    private Map<String, String> details;
    private String path;
}
