package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.domain.Education;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private final Map<Long,User> users = new HashMap<>();

    private final List<Education> educations = new ArrayList<>();

    @Override
    public long save(User user) {
        user.setId(users.size()+1);
        users.put(user.getId(),user);
        return user.getId();
    }

    @Override
    public User findById(long id) {
        return users.get(id);
    }

    @Override
    public void saveEducation(Education education) {
        educations.add(education);
    };

    @Override
    public List<Education> findEducationById(long id) {
        List<Education> educationsToReturn = new ArrayList<>();
        educations.forEach(education -> {
            if(education.getUserId() == id) {
                educationsToReturn.add(education);
            }
        });
        return educationsToReturn;
    }
}
