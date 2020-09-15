package com.thoughtworks.capacity.gtb.mvc.Service;

import com.thoughtworks.capacity.gtb.mvc.Domain.User;
import com.thoughtworks.capacity.gtb.mvc.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public Integer addUser(User user) {
        return userRepository.save(user);
    }


}
