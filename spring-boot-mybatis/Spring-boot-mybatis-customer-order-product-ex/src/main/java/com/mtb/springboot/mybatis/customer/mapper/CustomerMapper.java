package com.mtb.springboot.mybatis.customer.mapper;

import com.mtb.springboot.mybatis.customer.model.Address;
import com.mtb.springboot.mybatis.customer.model.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomerMapper {

    @Select("select * from customers")
    List<Customer> findAll();

    @Select("select * from customers where name = #{name}")
    @Results(value={
            @Result(property = "name",column = "name"),
            @Result(property = "addresses", javaType = List.class,column = "city",
            many = @Many(select = "findAddressByCustomer"))
    })
    Customer findCustomer(String name);

    @Select("Select * from address where customer_Address=#{customerAddress}")
    @Results(value ={
            @Result(property = "city",column = "city"),
            @Result(property = "country",column = "country"),
            @Result(property = "streetNr",column = "streetNr"),
            @Result(property = "plotno" ,column = "plotno")
    })
    List<Address> findAddressesByCustomer(String customerAddress);
    @Insert("INSERT INTO customers (\n" +
            //"                     id,\n" +
            "                     name\n" +
            "       address\n"+
            "                 )\n" +
            "                 VALUES (\n" +
            "                     #{name},\n" +
            "                 #{address});")
    @SelectKey(statement = "select LAST_INSERT_ROWID()",keyProperty = "id",
            before = false,resultType = Integer.class )
    void insert(Customer customer);

    @Delete("Delete from customers where name = #{name}")
    void deleteUser(String name);
}
