package com.mtb.ehcache.demo.cache;

import com.mtb.ehcache.demo.model.Users;
import com.mtb.ehcache.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author MithileshB
 * @created 21/11/2021 - 10:34 AM
 * @project demo
 */
@Component
public class UsersCache {

    @Autowired
    private UsersRepository usersRepository;

    @Cacheable(value="usersCache",key="#name")
    public Users getUser(String name){
        System.out.println("Retrieving from database for name:"+name);

        return usersRepository.findByName(name);
    }
}
