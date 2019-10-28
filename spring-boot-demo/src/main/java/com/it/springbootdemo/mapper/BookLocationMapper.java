package com.it.springbootdemo.mapper;


import com.it.springbootdemo.model.BookCatagory;
import com.it.springbootdemo.model.BookLocation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Repository
public interface BookLocationMapper {
    @Select("select * from bookLocation")
    List<BookLocation> getBookLocation();

    @Select("select * from bookLocation where FloorNo=#{FloorNo} AND ShelfNo=#{ShelfNo}")
    BookLocation findBookLocation(@Param("FloorNo") int FloorNo,
                                  @Param("ShelfNo") int ShelfNo);

    @Insert("insert into bookLocation(FloorNo,ShelfNo) values(#{FloorNo},#{ShelfNo})")
    void addBookLocation(@Param("FloorNo") int FloorNo,
                        @Param("ShelfNo") int ShelfNo);

    @Delete("delete from bookLocation where locationID=#{ID}")
    void deleteBookLocation(@Param("ID")int ID);
}
