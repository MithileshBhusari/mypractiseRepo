package com.mtb.jdbctransactionex.service;

import com.mtb.jdbctransactionex.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author MithileshB
 * @created 05/07/2020 - 6:22 PM
 * @project spring-boot-mybatis
 */
@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void insert(List<User> users) {
        for (final User user : users) {
            System.out.println("Inserting data for username :" + user.getName());
            jdbcTemplate.update("insert into USER(Name,Dept,Salary) values (?,?,?)",
                    preparedStatement -> {
                        preparedStatement.setString(1, user.getName());
                        preparedStatement.setString(2, user.getDepartment());
                        preparedStatement.setLong(3, user.getSalary());
                    });
        }
    }

    public List<User> getUsers() {

        System.out.println("Retrieve All users list");
        List<User> userList = jdbcTemplate.query("select Name,Dept,Salary from USER", (resultSet, i) -> new User(resultSet.getString("Name"),
                resultSet.getString("Dept"),
                resultSet.getLong("Salary")));
        return userList;
    }
}
