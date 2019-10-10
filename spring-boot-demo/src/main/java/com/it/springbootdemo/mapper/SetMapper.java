package com.it.springbootdemo.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SetMapper {

    @Select("select fine from changes")
     double getFine();

    @Select("select period from changes")
     double getPeriod();

    @Select("select deposit from changes")
     double getDeposit();


    @Update("update changes set fine=#{fine}")
    void setFine(@Param("fine") double fine);

    @Update("update changes set period=#{period}")
    void setPeriod(@Param("period") double period);

    @Update("update changes set deposit=#{deposit}")
    void setDeposit(@Param("deposit") double deposit);

}
