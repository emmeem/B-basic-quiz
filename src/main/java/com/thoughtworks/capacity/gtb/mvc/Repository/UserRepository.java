package com.thoughtworks.capacity.gtb.mvc.Repository;

import com.thoughtworks.capacity.gtb.mvc.Domain.Education;
import com.thoughtworks.capacity.gtb.mvc.Domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    long save(User user);

    User findById(long id);

    void saveEducation(Education education);

    List<Education> findEducationByid(long id);
}
