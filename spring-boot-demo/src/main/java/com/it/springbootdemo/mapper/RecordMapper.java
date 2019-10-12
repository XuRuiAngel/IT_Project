package com.it.springbootdemo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Mapper
@Repository
public interface RecordMapper {

    @Insert("insert into Record(UserId,bookId,BorrowTime) values(#{id},#{bookId},#{borrowTime})")
    void borrowBook(@Param("bookId")int bookId,@Param("id") int id, @Param("borrowTime") String borrowTime);
}
