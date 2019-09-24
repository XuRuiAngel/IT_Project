package com.it.springbootdemo.mapper;

import com.it.springbootdemo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user where username=#{username}")
    User findUserByName(@Param("username") String username);

    @Select("select * from user where id=#{id}")
    User findUserByName2(@Param("id") int id);

    @Select("select * from user where username=#{username}")
    User login(@Param("username") String username);

    @Insert("insert into user(username,balance,e_mail,password,flag,tele,registerdate) values (#{username},#{balance},#{e_mail},#{password},#{flag},#{tele},#{registerdate})")
    void insertUser( User user);

}
