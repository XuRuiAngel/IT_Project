package com.it.springbootdemo.service.service_impl;



import com.it.springbootdemo.mapper.UserMapper;
import com.it.springbootdemo.model.User;
import com.it.springbootdemo.service.UserService;
import com.it.springbootdemo.utils.EmailUtils;
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
    public String findUsernameByTele(String tele) {
        return userMapper.findUsernameByTele(tele);
    }

    @Override
    public int login(String tele, String password) {
        User user;
        user=userMapper.login(tele);
        if(user==null){
            return 4;
        }
        else if(user.getPassword().equals(password)){
            return user.getFlag();
        }
        else  return 5;
    }

    @Override
    public int registLibrarian(String tele, String username, String e_mail) {
        User user_check;
       user_check= userMapper.login(tele);
       if(user_check!=null)
       {
           return 0;
       }
       else{
           TimeUtil timeUtil = new TimeUtil();
           String nowdate= timeUtil.getFormatDateForFive();
           User user=new User(username,0,e_mail,"00010001",1,tele+"",nowdate);
           userMapper.insertUser(user);
           return 1;
       }

    }

    @Override
    public int registReader(String tele, String username, String e_mail, double balance) {
        User user_check;
        user_check = userMapper.login(tele);
        if(user_check!=null)
        {
            return 0;
        }
        else {
            TimeUtil timeUtil = new TimeUtil();
            String nowdate = timeUtil.getFormatDateForFive();
            User user = new User(username, balance, e_mail, 12345678 + "", 2, tele + "", nowdate);
            userMapper.insertReader(user);
            return 1;
        }
    }

    @Override
    public int resetPassword(String tele, String e_mail) {
        User user;
        user=userMapper.login(tele);
        if(user==null) return 0;
        else if(user.getE_mail().equals(e_mail)){
            String password=userMapper.getPasswordByTele(tele);
            String content="Your password is "+password+" , please keep your password properly.";
            boolean isSend = EmailUtils.sendEmail("Get back password.", e_mail, null, "<h3>"+content+"</h3>", null);
            if(isSend==true) return 1;
            else return 3;
        }
        else  return 2;

    }
}
