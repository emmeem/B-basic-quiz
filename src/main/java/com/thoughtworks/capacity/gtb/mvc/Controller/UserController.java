package com.thoughtworks.capacity.gtb.mvc.Controller;
// GTB: - ↑ package name 里一般不会使用大写字母
import com.thoughtworks.capacity.gtb.mvc.Domain.Education;
import com.thoughtworks.capacity.gtb.mvc.Domain.User;
import com.thoughtworks.capacity.gtb.mvc.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getUserById(id));
    }

    @PostMapping("/users")
    public ResponseEntity<Long> addUser(@RequestBody @Valid User user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.addUser(user));
    }

    @PostMapping("/users/{id}/educations")
    // GTB: - @ResponseStatus 了解一下
    public ResponseEntity addEducations(@PathVariable Integer id,
                                        @RequestBody @Valid Education education) {
        userService.addEducation(id, education);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}/educations")
    public ResponseEntity<List<Education>> getEducations(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getEducationById(id));
    }


}

