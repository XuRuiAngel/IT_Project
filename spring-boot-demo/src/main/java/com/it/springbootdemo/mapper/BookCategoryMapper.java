package com.it.springbootdemo.mapper;


import com.it.springbootdemo.model.BookCatagory;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookCategoryMapper {

    @Select("select * from BookCatagory")
    List<BookCatagory> getBookCatagory();

    @Select("select * from BookCatagory where Typename=#{Typename}")
    BookCatagory findBookCatagoryByName(@Param("Typename")String Typename);

    @Insert("insert into BookCatagory(Typename) values(#{Typename})")
    void addBookCatagory(@Param("Typename")String Typename);

    @Delete("delete from BookCatagory where categoryID=#{ID}")
    void deleteBookCatagory(@Param("ID")int ID);
}
