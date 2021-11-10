package pl.gozderapatryk.userservice.mapper;

import pl.gozderapatryk.userservice.dto.CreateUserDto;
import pl.gozderapatryk.userservice.dto.GetUserDto;
import pl.gozderapatryk.userservice.model.User;

import java.util.Objects;

public interface ModelMapper {

    static GetUserDto toGetUserDto(User user) {
        return Objects.isNull(user) ? null : GetUserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birthDate(user.getBirthDate())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }

    static User toUser(CreateUserDto createUserDto) {
        return Objects.isNull(createUserDto) ? null : User.builder()
                .username(createUserDto.getUsername())
                .email(createUserDto.getEmail())
                .password(createUserDto.getPassword())
                .build();
    }
}
