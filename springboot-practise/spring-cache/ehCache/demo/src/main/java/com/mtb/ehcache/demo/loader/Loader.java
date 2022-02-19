package com.mtb.ehcache.demo.loader;

import com.mtb.ehcache.demo.model.Users;
import com.mtb.ehcache.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MithileshB
 * @created 21/11/2021 - 10:47 AM
 * @project demo
 */
@Component
public class Loader {

    @Autowired
    private UsersRepository usersRepository;

    private List<Users> usersList;
    @PostConstruct
    public void load(){
            List<Users> usersList=getList();
            usersRepository.saveAll(usersList);
    }

    private List<Users> getList() {
        List<Users> usersList=new ArrayList<>();
        usersList.add(new Users("Mithilesh","Tech",123L));
        usersList.add(new Users("Priya","Ops",456L));
        return usersList;
    }
}
