package com.thoughtworks.capacity.gtb.mvc.Repository;

import com.thoughtworks.capacity.gtb.mvc.Domain.Education;
import com.thoughtworks.capacity.gtb.mvc.Domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    Integer save(User user);

    User findById(Integer id);

    void saveEducation(Education education);
}
