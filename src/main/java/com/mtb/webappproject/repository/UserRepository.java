package com.mtb.webappproject.repository;

import com.mtb.webappproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
