package com.thoughtworks.capacity.gtb.mvc.Service;

import com.thoughtworks.capacity.gtb.mvc.Domain.Education;
import com.thoughtworks.capacity.gtb.mvc.Domain.User;
import com.thoughtworks.capacity.gtb.mvc.Exception.EducationInfoIsNotExist;
import com.thoughtworks.capacity.gtb.mvc.Exception.UserNotFoundException;
import com.thoughtworks.capacity.gtb.mvc.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        education.setUserId(id);
        userRepository.saveEducation(education);
    }

    public List<Education> getEducationById(long id) {
        List<Education> education = userRepository.findEducationByid(id);
        if(education.isEmpty()) {
            throw new EducationInfoIsNotExist("教育信息不存在");
        }
        return userRepository.findEducationByid(id);
    }

}
