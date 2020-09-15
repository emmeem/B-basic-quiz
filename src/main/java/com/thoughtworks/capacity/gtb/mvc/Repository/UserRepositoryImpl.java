package com.thoughtworks.capacity.gtb.mvc.Repository;

import com.thoughtworks.capacity.gtb.mvc.Domain.User;
import org.springframework.stereotype.Repository;


import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private final Map<Integer,User> users = new HashMap<>();

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
}
