package com.it.springbootdemo.mapper;

import com.it.springbootdemo.controller.record;
import com.it.springbootdemo.model.Record;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RecordMapper {

    @Insert("insert into Record(UserId,bookId,BorrowTime,returnTime,fine,flag) values(#{userId},#{bookId},#{borrowTime},-1,-1,0)")
    void borrowBook(@Param("bookId") int bookId, @Param("userId") int userId, @Param("borrowTime") String borrowTime);

    @Select("select copyNumbers from book where bookId=#{bookId}")
    int getBookOrder(@Param("bookId") int bookId);

    @Update("update book set copyNumbers=#{copyNumbers} where bookId=#{bookId}")
    void updateOrder(@Param("copyNumbers") int copyNumbers,@Param("bookId") int bookId);

    @Select("select BorrowTime from Record where recordId=#{recordId}")
    String getBorrowTime(@Param("recordId") int recordId);

    @Update("update Record set returnTime=#{returnTime},fine=#{fine} where recordId=#{recordId}")
    void returnBook(@Param("recordId")int recordId,
                    @Param("returnTime") String returnTime,
                    @Param("fine") double fine);

    @Select("select bookId from Record where recordId=#{recordId}")
    int getBookId(@Param("recordId") int recordId);

    @Select("select userId from Reservation where bookId=#{bookId}")
    int getUserId(@Param("bookId") int bookId);


    @Select("select fine from changes")
    double getFine();



    @Select("select period from changes")
    double getPeriod();

    @Select("select deposit from changes")
    double getDeposit();

    @Select("select * from Record where userId=#{userId}")
    List<Record> getRecordByUserId(@Param("userId")int userId);

    @Select("select id from user where tele=#{tele}")
    int getUserIdBytele(@Param("tele") String tele);

    @Select("select * from Record ")
    List<Record> getRecord();


    @Select("select userId from Record where recordId=#{recordId}")
    int getUserIdByRecordId(@Param("recordId") int recordId);

    @Select("select balance from user where id=#{userId}")
    int getBalance(@Param("userId") int userId);

    @Select("select fine from Record where recordId=#{recordId}")
    int getFineByRecordId(@Param("recordId") int recordId);

    @Update("update Record set flag=1 where recordId=#{recordId}")
    void payFine(@Param("recordId")int recordId);

    @Select("select flag from Record where recordId=#{recordId}")
    int getFlag(@Param("recordId")int recordId);

    @Update("update user set balance=#{balance} where id=#{userId}")
    void changeBalance(@Param("userId")int userId,
                       @Param("balance") double balance);

    @Select("select e_mail from user where id=#{userId}")
    String getEmail(@Param("userId") int userId);

    @Select("select bookName from book where bookId=#{bookId}")
    String getBookName(@Param("bookId") int bookId);
}
