package com.clancode.labs.api;

import com.clancode.labs.services.custom.UserService;
import com.clancode.labs.to.UserTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("*")
public class UserHttpController {

    private final UserService service;

    public UserHttpController(UserService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public UserTO createNewUser(@RequestBody @Validated UserTO userTO) {
        return service.saveUser(userTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{user-id}",consumes = "application/json")
    public void updateUser(@PathVariable("user-id") Integer userId,
                            @RequestBody @Validated UserTO userTO) {
        userTO.setUserId(userId);
        service.updateUser(userTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{user-id}")
    public void deleteUser (@PathVariable("user-id") Integer userId) {
        service.deleteUser(userId);
    }

    @GetMapping(value = "/{user-id}", produces = "application/json")
    public UserTO getUser(@PathVariable("user-id") Integer userId) {
        return service.getUserDetails(userId);
    }

    @GetMapping(produces = "application/json")
    public List<UserTO> getAllUsers() {
        return service.getUserList();
    }
}
