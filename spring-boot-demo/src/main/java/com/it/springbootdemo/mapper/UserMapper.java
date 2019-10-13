package com.it.springbootdemo.mapper;

import com.it.springbootdemo.model.Book;
import com.it.springbootdemo.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @Select("select username from user where tele=#{tele}")
    String findUsernameByTele(@Param("tele") String tele);

    @Select("select password from user where tele=#{tele}")
    String getPasswordByTele(@Param("tele") String tele);

    @Select("select * from user where flag=1")
    List<User> getLibrarians();

    @Update("update user set username=#{username}, tele=#{tele} ,e_mail=#{e_mail} where id=#{id}")
    void editLibrarians(@Param("username") String username,
                        @Param("id") int id,
                        @Param("tele") String tele,
                        @Param("e_mail") String e_mail);


    @Delete("delete from user where id=#{id}")
    void deleteLibrarians(@Param("id") int id);

    @Select("select * from user where flag=2")
    List<User> getReaders();

    @Update("update user set username=#{username}, tele=#{tele} ,e_mail=#{e_mail} where id=#{id}")
    void editReaders(@Param("username") String username,
                        @Param("id") int id,
                        @Param("tele") String tele,
                        @Param("e_mail") String e_mail);


    @Delete("delete from user where id=#{id}")
    void deleteReaders(@Param("id") int id);


}
