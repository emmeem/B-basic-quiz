package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.domain.Education;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

// GTB: + Repository 单独提取了接口，后续可以将接口和实现放到不同的包里
@Repository
public interface UserRepository {

    long save(User user);

    User findById(long id);

    void saveEducation(Education education);

    List<Education> findEducationById(long id);
}
