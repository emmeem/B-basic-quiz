package com.thoughtworks.capacity.gtb.mvc.Service;

import com.thoughtworks.capacity.gtb.mvc.Domain.User;
import com.thoughtworks.capacity.gtb.mvc.Dto.UserRequest;
import com.thoughtworks.capacity.gtb.mvc.Exception.LoginErrorException;
import com.thoughtworks.capacity.gtb.mvc.Exception.UserIsExistException;
import com.thoughtworks.capacity.gtb.mvc.Exception.UserNotFoundException;
import com.thoughtworks.capacity.gtb.mvc.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public void save(UserRequest request) {
        User user = userRepository.findByName(request.getUsername());
        if(user != null) {
            throw new UserIsExistException("用户已存在");
        }
        User newUser = User.builder()
                    .name(request.getUsername())
                    .password(request.getPassword())
                    .email(request.getEmail())
                    .build();
        userRepository.save(newUser);
    }

    public User userLogin(String username, String password) {
        User user = userRepository.findByName(username);
        if(user == null) {
            throw new UserNotFoundException("用户不存在");
        }
        if(user.getPassword().equals(password)) {
            return user;
        }
        throw new LoginErrorException("用户名或密码错误");

    }

}
