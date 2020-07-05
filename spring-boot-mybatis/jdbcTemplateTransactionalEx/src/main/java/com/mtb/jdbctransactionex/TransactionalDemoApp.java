package com.mtb.jdbctransactionex;

import com.mtb.jdbctransactionex.model.User;
import com.mtb.jdbctransactionex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.List;

/**
 * @author MithileshB
 * @created 05/07/2020 - 6:34 PM
 * @project spring-boot-mybatis
 */
@SpringBootApplication
public class TransactionalDemoApp implements CommandLineRunner {

    @Autowired
    private UserService userService;
    public static void main(String[] args) {
        SpringApplication.run(TransactionalDemoApp.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            User user1 = new User("Mithilesh", "IT", 100L);
            User user2 = new User("Bhushan", "Electrical", 100L);

            List<User> users = Arrays.asList(user1, user2);

            userService.insert(users);
        }catch (RuntimeException e){
            System.out.println("Exception..........!!!!!!!!!  :"+e.getMessage());
        }

        try {
            User user4 = new User("Nitesh Khandare", "MSEB", 100L);
            User user5=new User("Gaurish Shah","TELECOM",100L);
            List<User> users = Arrays.asList(user4,user5);

            userService.insert(users);
        }catch (RuntimeException e){
            System.out.println("Exception..........!!!!!!!!!  :"+e.getMessage());
        }
        System.out.println(userService.getUsers());
    }
}
