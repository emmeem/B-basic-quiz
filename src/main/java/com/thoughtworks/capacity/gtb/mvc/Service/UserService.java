package com.thoughtworks.capacity.gtb.mvc.Service;

import com.thoughtworks.capacity.gtb.mvc.Domain.User;
import com.thoughtworks.capacity.gtb.mvc.Dto.UserRequest;
import com.thoughtworks.capacity.gtb.mvc.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public void save(UserRequest request) {
        User user = User.builder()
                    .name(request.getName())
                    .password(request.getPassword())
                    .email(request.getEmail())
                    .build();
        userRepository.save(user);
    }

}
