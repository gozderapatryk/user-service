package pl.gozderapatryk.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.gozderapatryk.userservice.validation.FieldMatch;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldMatch.List({
        @FieldMatch(
                firstField = "password",
                secondField = "passwordConfirmation",
                message = "Passwords do not match!"
        ),
        @FieldMatch(
                firstField = "email",
                secondField = "emailConfirmation",
                message = "Email addresses do not match!"
        )
})
public class CreateUserDto {
    @NotBlank
    private String username;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String emailConfirmation;
    @NotBlank
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–\\[{}\\].:;',?/*~$^+=<>]).{8,20}$")
    private String password;
    @NotBlank
    private String passwordConfirmation;
}
