package com.it.springbootdemo.mapper;

import com.it.springbootdemo.model.Reservation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Select("select * from Reservation")
    List<Reservation> getAllReservation();

    @Delete("delete from Reservation where ID=#{ID}")
    void deleteReservation(@Param("ID")int ID);
}
