package com.mtb.springboot.mybatis.customer.mapper;

import com.mtb.springboot.mybatis.customer.model.Address;
import com.mtb.springboot.mybatis.customer.model.Customer;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface CustomerMapper {

    @Select("select * from customers")
    @Results(value={
            @Result(property = "customerId",column="customerId"),
            @Result(property = "name",column = "name"),
            @Result(property = "addresses", javaType = List.class,column = "customerId",
                    many = @Many(select = "findAddressesByCustomer"))
    })
    List<Customer> getAllCustomers();

    @Select("select * from customers where customerId = #{customerId}")
    @Results(value={
            @Result(property = "customerId",column="customerId"),
            @Result(property = "name",column = "name"),
            @Result(property = "addresses", javaType = List.class,column = "customerId",
            many = @Many(select = "findAddressesByCustomer"))
    })
    Customer getCustomer(int customerId);

    @Select("Select * from address where customerId=#{customerId}")
    @Results(value ={
            @Result(property = "city",column = "city"),
            @Result(property = "country",column = "country"),
            @Result(property = "streetNr",column = "streetNr"),
            @Result(property = "plotno" ,column = "plotno")
    })
    List<Address> findAddressesByCustomer(String customerId);
   /* @Insert("INSERT INTO customers (\n" +
            "                     name\n"+
            "                 )\n" +
            "                 VALUES (\n" +
            "                     #{name}\n")*/
   @Insert("INSERT INTO customers (NAME ) VALUES (#{name})")
   @SelectKey(statement = "select LAST_INSERT_ROWID()",keyProperty = "customerId",
            before = false,resultType = Integer.class)
   @Options(useGeneratedKeys = true)
    void addCustomer(Customer customer);

    @Delete("Delete from customers where name = #{name}")
    void deleteUser(String name);

    @Insert("INSERT INTO address (plotno,city ,country, streetNr,customerId) VALUES ( #{address.plotno},#{address.city},#{address.country}, #{address.streetNr},#{customerId})")
    @SelectKey(statement = "select LAST_INSERT_ROWID()",keyProperty = "id",
            before = false,resultType = Integer.class )
    void addCustomerAddress(@Param("address") Address address,@Param("customerId") int customerId);
}
