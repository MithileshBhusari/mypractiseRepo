package com.mtb.designpatter.builderpatternex;

import javax.jws.soap.SOAPBinding;

/**
 * @author MithileshB
 * @created 15/06/2020 - 9:26 AM
 * @project DesignPattern
 */
public class User {
    private final String firstName;//required
    private final String lastName;//required
    private final int age;//optional
    private final String phone;//optional
    private final String address;//optional

    private User(UserBuilder builder){
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.age=builder.age;
        this.phone=builder.phone;
        this.address=builder.address;
    }


    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class UserBuilder{
        private  String firstName;
        private  String lastName;
        private int age;
        private String phone;
        private String address;

        public UserBuilder(String firstName,String lastName){
            this.firstName=firstName;
            this.lastName=lastName;
        }
        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }
}
/*Builder pattern aims to “Separate the construction of a complex object from its representation
so that the same construction process can create different representations.
*/
class UserBuilderDemo{
    public static void main(String[] args) {
        User user=new User.UserBuilder("Mithilesh","Bhusari")
                .setAge(28)
                .setPhone("12345")
                .setAddress("Pune")
                .build();

        System.out.println(user);
    }
}