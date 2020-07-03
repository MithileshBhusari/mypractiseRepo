package com.mtb.namednativequeryex.repository;

import com.mtb.namednativequeryex.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author MithileshB
 * @created 03/07/2020 - 6:42 PM
 * @project spring-boot-mybatis
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmailAddress(String emailAddress);
    User findByLastName(String lastName);
}
