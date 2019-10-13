package com.it.springbootdemo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ReservationMapper {
    @Insert("insert into Reservation(userId,bookId,reserveTime) values(#{userId},#{bookId},#{reserveTime}) ")
    int addReservation(@Param("bookId") int bookId,
                       @Param("userId") int userId,
                       @Param("reserveTime") String reserveTime);
}
