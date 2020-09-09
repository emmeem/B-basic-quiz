package com.thoughtworks.capacity.gtb.mvc.Repository;

import com.thoughtworks.capacity.gtb.mvc.Domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryUtils implements UserRepository{
    private final List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        user.setId(users.size() + 1);
        users.add(user);
        return user;
    }
}
