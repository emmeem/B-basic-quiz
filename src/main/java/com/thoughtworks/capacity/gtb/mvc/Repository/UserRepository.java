package com.thoughtworks.capacity.gtb.mvc.Repository;

import com.thoughtworks.capacity.gtb.mvc.Domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    User save(User user);

}
