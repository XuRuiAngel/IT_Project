package com.it.springbootdemo.mapper;


import com.it.springbootdemo.model.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {

    @Select("select * from book where ${key}=#{text}")
    List<Book>  searchBook(@Param("key") String key,@Param("text") String text);

    @Insert(
           "insert into book(price,location,bookname,author,press) values(#{price},#{location},#{bookname},#{author},#{press})"
    )
    void insertBookWithoutISBN(@Param("price")String price, @Param("location")String location,@ Param("bookname") String bookname, @Param("author")String author, @Param("press")String press);

    @Insert(
            "insert into book(ISBN,price,location,bookname,author,press) values(#{ISBN},#{price},#{location},#{bookname},#{author},#{press})"
    )
    void insertBookWithISBN(@Param("ISBN")String ISBN,@Param("price")String price, @Param("location")String location,@ Param("bookname") String bookname, @Param("author")String author, @Param("press")String press);
}