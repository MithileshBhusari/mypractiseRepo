package com.mtb.namednativequeryex.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author MithileshB
 * @created 03/07/2020 - 6:34 PM
 * @project spring-boot-mybatis
 */
@Entity
@Table(name = "namedqueryex_users")
@NamedNativeQuery(name="User.findByEmailAddress",query = "select * from namedqueryex_users where email_address=?1",resultClass = User.class)
@NamedNativeQueries(value = {
        @NamedNativeQuery(name="User.findByLastName",query = "select * from namedqueryex_users where last_name=?1",resultClass = User.class)
})
public class User {

    private long id;
    private String firstname;
    private String last_name;
    private Date start_date;
    private String email_address;
    private int age;
    private int active;

    @Id //To recognize objects id
    @GeneratedValue(strategy = GenerationType.AUTO) //To indicate id should be generated automatically
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public Date getStartDate() {
        return start_date;

    }

    public void setStartDate(Date startDate) {
        this.start_date = startDate;
    }

    public String getEmailAddress() {
        return email_address;
    }

    public void setEmailAddress(String emailAddress) {
        this.email_address = emailAddress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstname + '\'' +
                ", lastName='" + last_name + '\'' +
                ", startDate=" + start_date +
                ", emailAddress='" + email_address + '\'' +
                ", age=" + age +
                ", active=" + active +
                '}';
    }
}
