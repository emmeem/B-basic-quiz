package com.thoughtworks.capacity.gtb.mvc.Controller;

import com.thoughtworks.capacity.gtb.mvc.Domain.User;
import com.thoughtworks.capacity.gtb.mvc.Dto.UserRequest;
import com.thoughtworks.capacity.gtb.mvc.Service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@Validated
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
    public User login(@RequestParam ("username")
                      @Pattern(regexp = "^[0-9a-zA-Z_]{1,}$", message= "用户名不合法,只能由字母、数字或下划线组成")
                      @Size(min=3, max=10, message= "用户名不合法,长度为3到10位")
                      String username,
            @RequestParam("password")
            @Size(min=5, max=12, message= "密码不合法,长度为5到12位")
            String password) {
        return userService.userLogin(username,password);
    }
}
