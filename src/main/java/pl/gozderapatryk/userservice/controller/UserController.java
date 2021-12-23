package pl.gozderapatryk.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.gozderapatryk.userservice.dto.CreateUserDto;
import pl.gozderapatryk.userservice.dto.GetUserDto;
import pl.gozderapatryk.userservice.mapper.ModelMapper;
import pl.gozderapatryk.userservice.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Validated
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public GetUserDto findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping
    public List<GetUserDto> findAll() {
        return userService.findAll()
                .stream()
                .map(ModelMapper::toGetUserDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public Long signup(@RequestBody @Valid CreateUserDto createUserDto) {
        return userService.signup(createUserDto);
    }
}
