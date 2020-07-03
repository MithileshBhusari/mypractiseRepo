package com.mtb.namednativequeryex;

import com.mtb.namednativequeryex.model.User;
import com.mtb.namednativequeryex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

/**
 * @author MithileshB
 * @created 03/07/2020 - 6:44 PM
 * @project spring-boot-mybatis
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setActive(1);
        user.setAge(28);
        user.setEmailAddress("mtb@gmail.com");
        user.setFirstName("Mithilesh");
        user.setLastName("Bhusari");
        user.setStartDate(new Date());
        User user1=userRepository.save(user);

        System.out.println("--------"+user.getId());

        System.out.println("------------NamedNativeQuery-----------------");
        System.out.println("------------findByEmailAddress---------------");

        User user2=userRepository.findByEmailAddress("mtb@gmail.com");

        System.out.println(user2);

        System.out.println("------------NamedNativeQueries-----------------");
        System.out.println("------------findByLastName---------------");
        User user3=userRepository.findByLastName("Bhusari");
        System.out.println(user3);


    }
}
