package pl.gozderapatryk.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.gozderapatryk.userservice.dto.GetUserDto;
import pl.gozderapatryk.userservice.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public GetUserDto findById(@PathVariable Long id) {
        return userService.findById(id);
    }
}
