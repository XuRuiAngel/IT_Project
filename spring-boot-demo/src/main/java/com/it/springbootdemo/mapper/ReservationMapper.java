package com.it.springbootdemo.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ReservationMapper {
    @Insert("insert into Reservation(userId,bookId,reserveTime) values(#{userId},#{bookId},#{reserveTime}) ")
    int addReservation(@Param("bookId") int bookId,
                       @Param("userId") int userId,
                       @Param("reserveTime") String reserveTime);

    @Select("select copyNumbers from book where bookId=#{bookId}")
    int getBookOrder(@Param("bookId") int bookId);

    @Update("update book set copyNumbers=#{copyNumbers} where bookId=#{bookId}")
    void updateOrder(@Param("copyNumbers") int copyNumbers,@Param("bookId") int bookId);
}
