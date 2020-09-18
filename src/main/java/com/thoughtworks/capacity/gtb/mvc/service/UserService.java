package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.Education;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNotFoundException;
import com.thoughtworks.capacity.gtb.mvc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public User getUserById(long id) {
        User user = userRepository.findById(id);
        if(user != null) {
            return user;
        }
        throw new UserNotFoundException("用户不存在");
    }

    public long addUser(User user) {
        return userRepository.save(user);
    }

    public void addEducation(long id, Education education) {
        User user = userRepository.findById(id);
        if(user == null ) {
            throw new UserNotFoundException("用户不存在");
        }
        education.setUserId(id);
        userRepository.saveEducation(education);
    }

    public List<Education> getEducationById(long id) {
        List<Education> educations = userRepository.findEducationById(id);
        if(educations.isEmpty()) {
            return null;
        }
        return educations;
    }

}
