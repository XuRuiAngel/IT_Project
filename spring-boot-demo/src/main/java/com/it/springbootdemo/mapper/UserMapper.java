package com.it.springbootdemo.mapper;

import com.it.springbootdemo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    @Select("select name from user1 where id=#{id}")
    String findUserByName(@Param("id") int id);

    @Select("select * from user1 where id=#{id}")
    User findUserByName2(@Param("id") int id);
}
