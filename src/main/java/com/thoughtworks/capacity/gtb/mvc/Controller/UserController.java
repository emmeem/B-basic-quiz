package com.thoughtworks.capacity.gtb.mvc.Controller;

import com.thoughtworks.capacity.gtb.mvc.Domain.User;
import com.thoughtworks.capacity.gtb.mvc.Dto.UserRequest;
import com.thoughtworks.capacity.gtb.mvc.Service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/register")
    public void addUser(@Valid  @RequestBody UserRequest userRequest) {
        userService.save(userRequest);
    }

    @GetMapping(path = "/login")
    public User login(
            @RequestParam ("username") String username,
            @RequestParam("password") String password) {
        User user=userService.userLogin(username,password);
        return user;
    }
}
