package com.mtb.ehcache.demo.resource;

import com.mtb.ehcache.demo.cache.UsersCache;
import com.mtb.ehcache.demo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MithileshB
 * @created 21/11/2021 - 10:28 AM
 * @project demo
 */
@RestController
@RequestMapping(value = "/rest/users")
public class UsersResource {

    @Autowired
    private UsersCache usersCache;

    @GetMapping(value = "/{name}")
    public Users getUser(@PathVariable final String name){
        return usersCache.getUser(name);
    }
}
