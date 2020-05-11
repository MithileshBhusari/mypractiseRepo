package com.mtb.springboot.mybatis.products.mapper;

import com.mtb.springboot.mybatis.orders.model.PurchaseOrder;
import com.mtb.springboot.mybatis.products.model.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("select * from products where orderId = #{orderId}")
    @Results(value = {
            @Result(property = "productId", column = "productId"),
            @Result(property = "name", column = "name"),
            @Result(property = "price", column = "price")
           /* @Result(property = "addresses", javaType = List.class,column = "customerId",
                    many = @Many(select = "findAddressesByCustomer"))*/
    })
    public List<Product> getAllProducts(int customerId, int orderId);

    @Select("select * from products where orderId = #{orderId} and productId =#{productId}")
    @Results(value = {
            @Result(property = "productId", column = "productId"),
            @Result(property = "name", column = "name"),
            @Result(property = "price", column = "price")
           /* @Result(property = "addresses", javaType = List.class,column = "customerId",
                    many = @Many(select = "findAddressesByCustomer"))*/
    })
    Product getProduct(int customerId, int orderId, int productId);


    @Insert("INSERT INTO products (name,price,orderId) VALUES (#{product.name},#{product.price},#{orderId})")
    @SelectKey(statement = "select LAST_INSERT_ROWID()",keyProperty = "orderId",
            before = false,resultType = Integer.class)
    @Options(useGeneratedKeys = true)
    void addOrder(Product product, int customerId, int orderId);

    @Delete("Delete from products where orderId= #{orderId} and productId=#{productId}")
    void deleteOrder(int orderId, int productId);
}
