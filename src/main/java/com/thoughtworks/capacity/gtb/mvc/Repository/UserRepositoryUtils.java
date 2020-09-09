package com.thoughtworks.capacity.gtb.mvc.Repository;

import com.thoughtworks.capacity.gtb.mvc.Domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryUtils implements UserRepository{

    private final Map<String,User> users = new HashMap<>();

    @Override
    public User save(User user) {
        user.setId(users.size() + 1);
        users.put(user.getName(),user);
        return user;
    }

    @Override
    public User findByName(String username) {
        User user = users.get(username);
        return user;
    }
}
