package pl.gozderapatryk.userservice.mapper;

import pl.gozderapatryk.userservice.dto.GetUserDto;
import pl.gozderapatryk.userservice.model.User;

import java.util.Objects;

public interface ModelMapper {

    public static GetUserDto toGetUserDto(User user) {
        return Objects.isNull(user) ? null : GetUserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}
