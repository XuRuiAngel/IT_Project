package com.it.springbootdemo.mapper;


import com.it.springbootdemo.model.Income;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IncomeMapper {

    @Insert("insert into Income(time,type,money) values(#{time},#{type},#{money})")
    void addIncome(@Param("time")String time,
                   @Param("type")int type,
                   @Param("money")double money);


    @Select("select * from Income")
    List<Income> getIncome();
}
