package com.mtb.service.userservice.repository;

import com.mtb.service.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author MithileshB
 * @created 28/01/2022 - 9:35 PM
 * @project user-service
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(Long userId);
}
