package com.thoughtworks.capacity.gtb.mvc.Repository;

import com.thoughtworks.capacity.gtb.mvc.Domain.Education;
import com.thoughtworks.capacity.gtb.mvc.Domain.User;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private final Map<Integer,User> users = new HashMap<>();

    private final List<Education> educations = new ArrayList<>();

    @Override
    public Integer save(User user) {
        user.setId(users.size()+1);
        users.put(user.getId(),user);
        return user.getId();
    }

    @Override
    public User findById(Integer id) {
        return users.get(id);
    }

    @Override
    public void saveEducation(Education education) {
        educations.add(education);
    };

    @Override
    public List<Education> findEducationByid(Integer id) {
        List<Education> reEducations = new ArrayList<>();
        educations.forEach(education -> {
            if(education.getUserId() == id) {
                reEducations.add(education);
            }
        });
        return reEducations;
    }
}
