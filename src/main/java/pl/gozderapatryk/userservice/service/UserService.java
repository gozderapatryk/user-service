package pl.gozderapatryk.userservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.gozderapatryk.userservice.dto.CreateUserDto;
import pl.gozderapatryk.userservice.dto.GetUserDto;
import pl.gozderapatryk.userservice.exceptions.UserNotFoundException;
import pl.gozderapatryk.userservice.mapper.ModelMapper;
import pl.gozderapatryk.userservice.repository.UserRepository;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public GetUserDto findById(@NotNull Long id) {
        return userRepository
                .findById(id)
                .map(ModelMapper::toGetUserDto)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id: %s does not exist in the database.", id)));
    }

    public Long signup(@NotNull CreateUserDto createUserDto) {
        if (userRepository.existsByUsername(createUserDto.getUsername())) {
            throw new ValidationException(String.format("User with username: %s already exist in the database.", createUserDto.getUsername()));
        }

        if (userRepository.existsByEmail(createUserDto.getEmail())) {
            throw new ValidationException(String.format("User with email: %s already exist in the database.", createUserDto.getEmail()));
        }

        createUserDto.setPassword(passwordEncoder.encode(createUserDto.getPassword()));

        return userRepository.save(ModelMapper.toUser(createUserDto)).getId();
    }
}
