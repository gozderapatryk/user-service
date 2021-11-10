package pl.gozderapatryk.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetUserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String username;
    private String email;
}
