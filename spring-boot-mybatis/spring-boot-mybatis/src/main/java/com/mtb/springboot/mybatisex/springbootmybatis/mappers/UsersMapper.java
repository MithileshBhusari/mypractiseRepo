package com.mtb.springboot.mybatisex.springbootmybatis.mappers;

import com.mtb.springboot.mybatisex.springbootmybatis.model.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

@Mapper
public interface UsersMapper {
    @Select("select * from users")
    List<Users> findAll();

    @Insert("INSERT INTO users (\n" +
            //"                     id,\n" +
            "                     name,salary\n" +
            "                 )\n" +
            "                 VALUES (\n" +
            "                     #{name},\n" +
            "                     #{salary}\n" +
            "                 );")
    @SelectKey(statement = "select LAST_INSERT_ROWID()",keyProperty = "id",
    before = false,resultType = Integer.class )
    void insert(Users users);
}
