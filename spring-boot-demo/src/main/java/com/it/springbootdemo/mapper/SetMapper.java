package com.it.springbootdemo.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SetMapper {

    @Select("select fine from change")
     double getFine();

    @Select("select period from change")
     double getPeriod();

    @Select("select deposit from change")
     double getDeposit();


    @Update("update change set fine=#{fine}")
    void setFine(@Param("fine") double fine);

    @Update("update change set period=#{period}")
    void setPeriod(@Param("period") double period);

    @Update("update change set deposit=#{deposit}")
    void setDeposit(@Param("deposit") double deposit);

}
