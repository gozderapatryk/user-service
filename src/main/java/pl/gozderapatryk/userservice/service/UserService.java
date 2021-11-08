package pl.gozderapatryk.userservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gozderapatryk.userservice.dto.GetUserDto;
import pl.gozderapatryk.userservice.exceptions.UserNotFoundException;
import pl.gozderapatryk.userservice.mapper.ModelMapper;
import pl.gozderapatryk.userservice.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public GetUserDto findById(Long id) {
        return userRepository
                .findById(id)
                .map(ModelMapper::toGetUserDto)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id: %s does not exist in the database.", id)));
    }
}
