package com.it.springbootdemo.service.service_impl;



import com.it.springbootdemo.mapper.UserMapper;
import com.it.springbootdemo.model.User;
import com.it.springbootdemo.service.UserService;
import com.it.springbootdemo.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public User test2(int id) {
        return  userMapper.findUserByName2(id);
    }

    @Override
    public int login(String username, String password) {
        User user;
        user=userMapper.login(username);
        if(user==null){
            return 4;
        }
        else if(user.getPassword().equals(password)){
            return user.getFlag();
        }
        else  return 5;
    }

    @Override
    public int registAdmin(String username, String password, String e_mail) {
        User user_check;
       user_check= userMapper.findUserByName(username);
       if(user_check!=null)
       {
           return 0;
       }
       else{
           TimeUtil timeUtil = new TimeUtil();
           String nowdate= timeUtil.getFormatDateForFive();
           User user=new User(username,0,e_mail,password,0,123456+"",nowdate);
           userMapper.insertUser(user);
           return 1;
       }

    }
}
