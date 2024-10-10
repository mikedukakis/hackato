package imf.hackato.controller;

import imf.hackato.entity.User;
import imf.hackato.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Data
@RestController
@RequestMapping("/appActivities/user")
@Tag(name = "User", description = "Operations related to user management")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Create user", description = "Creates a new user.")
    @PostMapping("/user")
    public Mono<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @Operation(summary = "Update user", description = "Updates an existing user, located with Id.")
    @PutMapping("/{id}")
    public Mono<User> updateUser(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @Operation(summary = "Find user", description = "Finds an existing user, located with Id.")
    @GetMapping("/{id}")
    public Mono<User> findUser(@PathVariable String id) {
        return userService.findUserById(id);
    }

    @Operation(summary = "Delete user", description = "Deletes an existing user, located with Id.")
    @DeleteMapping("/{id}")
    public Mono<Void> deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }

}
