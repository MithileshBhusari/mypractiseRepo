package com.mtb.springboot.mybatis.orders.mapper;

import com.mtb.springboot.mybatis.orders.model.PurchaseOrder;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PurchaseOrderMapper {

    @Select("select * from orders where customerId=#{customerId}")
    @Results(value={
            @Result(property = "orderId",column="orderId"),
            @Result(property = "date",column = "date"),
            @Result(property = "customerId",column = "customerId")
    })
    public List<PurchaseOrder> getAllPurchaseOrders(int customerId);

    @Select("select * from orders where customerId =#{customerId} and orderId = #{id}")
    @Results(value={
            @Result(property = "orderId",column="orderId"),
            @Result(property = "date",column = "date"),
       /*     @Result(property = "productList", javaType = List.class,column = "orderId",
                    many = @Many(select = "findProductsByOrderId"))*/
    })
    public PurchaseOrder getOrder(int id,int customerId);


    @Insert("INSERT INTO orders (date,customerId ) VALUES (#{order.date},#{customerId})")
    @SelectKey(statement = "select LAST_INSERT_ROWID()",keyProperty = "orderId",
            before = false,resultType = Integer.class)
    @Options(useGeneratedKeys = true)
    public void addOrder(PurchaseOrder order,int customerId) ;

    @Delete("Delete from orders where orderId= #{id} and customerId=#{customerId}")
    public void deleteOrder(int id,int customerId);
}
