package com.it.springbootdemo.service.service_impl;



import com.it.springbootdemo.mapper.UserMapper;
import com.it.springbootdemo.model.Book;
import com.it.springbootdemo.model.User;
import com.it.springbootdemo.service.UserService;
import com.it.springbootdemo.utils.EmailUtils;
import com.it.springbootdemo.utils.TimeUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
            //用户不存在
            return 4;
        }
        else if(user.getPassword().equals(password)){
            //密码正确，允许登录
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

    @Override
    public JSONObject getLibrarians() {
        List<User> users=null;
        users=userMapper.getLibrarians();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray=new JSONArray();
        for(User user:users)
        {
            JSONObject result=new JSONObject();
            result.put("username",user.getUsername());
            result.put("id",user.getUserId());
            result.put("tele",user.getTele());
            result.put("e_mail",user.getE_mail());
            jsonArray.add(result);
        }
        jsonObject.put("result",jsonArray);
        return jsonObject;
    }

    @Override
    public int editLibrarians(String username,int id, String tele, String e_mail) {

        User testUser=null;
        testUser=userMapper.login(tele);
        if(testUser!=null&&id!=testUser.getUserId()){
            return 0;
        }
        else {
            userMapper.editLibrarians(username,id,tele,e_mail);
            return 1;
        }

    }

    @Override
    public int deleteLibrarians(int id) {
        userMapper.deleteLibrarians(id);
        return 1;
    }

    @Override
    public JSONObject getReaders() {
        List<User> users=null;
        users=userMapper.getReaders();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray=new JSONArray();
        for(User user:users)
        {
            JSONObject result=new JSONObject();
            result.put("username",user.getUsername());
            result.put("id",user.getUserId());
            result.put("tele",user.getTele());
            result.put("e_mail",user.getE_mail());
            jsonArray.add(result);
        }
        jsonObject.put("result",jsonArray);
        return jsonObject;
    }

    @Override
    public int editReaders(String username,int id, String tele, String e_mail) {

        User testUser=null;
        testUser=userMapper.login(tele);
        if(testUser!=null&&id!=testUser.getUserId()){
            return 0;
        }
        else {
            userMapper.editReaders(username,id,tele,e_mail);
            return 1;
        }

    }

    @Override
    public int deleteReaders(int id) {
        userMapper.deleteLibrarians(id);
        return 1;
}

    @Override
    public int changePassword(String tele, String pPassword, String cPassword) {
        String rPassword=userMapper.getPasswordByTele(tele);
        if(rPassword.equals(pPassword)){
        userMapper.changePassword(tele,cPassword);
        return 1;
        }

        else return 0;
    }

    @Override
    public JSONObject getReadByTele(String tele) {
        JSONObject jsonObject = new JSONObject();

        List<User> users=null;
        users=userMapper.getReadByTele(tele);
        for(User user :users){
        jsonObject.put("id" ,user.getUserId());
        jsonObject.put("username" ,user.getUsername());
        jsonObject.put("balance" ,user.getBalance());
        jsonObject.put("e_mail" ,user.getE_mail());
        jsonObject.put("tele" ,user.getTele());
        jsonObject.put("regitherdate" ,user.getRegisterdate());}
        return jsonObject;
    }

    @Override
    public void addIncome(String time, int type, double money) {
        userMapper.addIncome(time,type,money);
    }

    @Override
    public double getDeposit() {
       return userMapper.getDeposit();

    }

    @Override
    public int editInformation(String username, int id, String e_mail) {
        userMapper.editInformation(username,id,e_mail);
        return 0;
    }
}
