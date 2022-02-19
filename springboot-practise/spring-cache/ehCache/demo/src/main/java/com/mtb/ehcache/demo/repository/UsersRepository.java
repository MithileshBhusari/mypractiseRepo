package com.mtb.ehcache.demo.repository;

import com.mtb.ehcache.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author MithileshB
 * @created 21/11/2021 - 10:37 AM
 * @project demo
 */

public interface UsersRepository extends JpaRepository<Users,Long> {
    Users findByName(String name);
}
