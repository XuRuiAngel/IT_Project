package com.it.springbootdemo.controller;

import com.it.springbootdemo.service.UserService;
import com.it.springbootdemo.utils.TimeUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class login {

    @Autowired
    UserService userService;
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam("tele") String tele,
                        @RequestParam("password") String password,
                        HttpSession session){
        int result;
        result=userService.login(tele,password);
        if(result==4){
            return "Account does not exist!";
        }
        else if(result==5){
            return "Password error!";
        }
        else {
            session.setAttribute("tele",tele);
            return result+"";}
    }


    @PostMapping("/registLibrarian")
    @ResponseBody
    public String registAdmin(@RequestParam("tele") String tele,
                               @RequestParam("username") String username,
                               @RequestParam("e_mail") String e_mail){
        int result;
        result=userService.registLibrarian(tele,username,e_mail);
         if(result==0)
         {
             return "The account has been registered!";
         }
         else return "success!";
    }

    @PostMapping("/registReader")
    @ResponseBody
    public String registReader(
            @RequestParam("tele") String tele,
            @RequestParam("username") String username,
            @RequestParam("e_mail") String e_mail,
            @RequestParam("balance") double balance){
            double deposit=userService.getDeposit();
                if(balance<deposit)
                {
                    return "Not enough money";
                }
                else
                {
                    int result;
                    result=userService.registReader(tele,username,e_mail,balance);
                    if(result==0)
                    {
                        return "The account has been registered!";
                    }
                    else {
                        TimeUtil timeUtil = new TimeUtil();
                        String nowdate = timeUtil.getFormatDateForFive();
                        userService.addIncome(nowdate,0,deposit);
                        return "success!";
                    }
                }
                }

    @GetMapping("/resetPassword")
    @ResponseBody
    public String resetPassword(@RequestParam("tele") String tele,
                                @RequestParam("e_mail") String e_mail){
        int result=0;
        result=userService.resetPassword(tele,e_mail);
        if(result==0){
            return "Account does not exist!";
        }
        else if (result==1){
            return "Success";
        }
        else {
            return "Error e_mail!";
        }
     }

     @GetMapping("/getLibrarians")
     @ResponseBody
     public JSONObject getLibrarians(){
         return userService.getLibrarians();
     }

    @GetMapping("/getReaders")
    @ResponseBody
    public JSONObject getReaders(){
        return userService.getReaders();
    }


    @PostMapping("/editLibrarians")
    @ResponseBody
    public String editLibrarians(@RequestParam("username") String username,
                                 @RequestParam("id") int id,
                                 @RequestParam("tele")String tele,
                                 @RequestParam("e_mail") String e_mail){
       int result= userService.editLibrarians(username,id,tele,e_mail);
       if(result==0){
           return "The account already exists!Fails!";
       }
       else return "success";
     }

    @PostMapping("/editReaders")
    @ResponseBody
    public String editReaders(@RequestParam("username") String username,
                                 @RequestParam("id") int id,
                                 @RequestParam("tele")String tele,
                                 @RequestParam("e_mail") String e_mail){
        int result= userService.editReaders(username,id,tele,e_mail);
        if(result==0){
            return "The account already exists!Fails!";
        }
        else return "success";
    }



     @PostMapping("/changePassword")
     @ResponseBody
     public String changePassword(@RequestParam("tele") String tele,
                                  @RequestParam("pPassword") String pPassword,
                                  @RequestParam("cPassword") String cPassword){

        int result=userService.changePassword(tele, pPassword, cPassword);
        if(result==1)  return "success!";
        else return "fail!";
     }



    @PostMapping("/deleteLibrarians")
    @ResponseBody
    public void deleteLibrarians(@RequestParam("id") int id){
       userService.deleteLibrarians(id);

    }

    @PostMapping("/deleteReaders")
    @ResponseBody
    public void deleteReaders(@RequestParam("id") int id){
        userService.deleteReaders(id);

    }


    @GetMapping("/getReadByTele")
    @ResponseBody
    public JSONObject getReadByTele(@RequestParam("tele") String tele){
        return userService.getReadByTele(tele);
    }


}
