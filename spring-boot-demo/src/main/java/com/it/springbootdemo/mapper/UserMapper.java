package com.it.springbootdemo.mapper;

import com.it.springbootdemo.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user where username=#{username}")
    User findUserByName(@Param("username") String username);

    @Select("select * from user where id=#{id}")
    User findUserByName2(@Param("id") int id);

    @Select("select * from user where tele=#{tele}")
    User login(@Param("tele") String tele);

    @Insert("insert into user(username,balance,e_mail,password,flag,tele,registerdate) values (#{username},#{balance},#{e_mail},#{password},#{flag},#{tele},#{registerdate})")
    void insertUser( User user);

    @Insert("insert into user(username,balance,e_mail,password,flag,tele,registerdate) values (#{username},#{balance},#{e_mail},#{password},#{flag},#{tele},#{registerdate})")
    void insertReader(User user);

    @Update("update user set password='12345678' where tele=#{tele}")
    void resetPassword(@Param("tele") String tele);
}
