package com.it.springbootdemo.controller;


import com.it.springbootdemo.model.RandomValidateCodeUtil;
import com.it.springbootdemo.model.User;
import com.it.springbootdemo.service.UserService;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.Random;

@Controller
public class test {
    @RequestMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {

        }
    }
    @PostMapping("/check")
    @ResponseBody
    public String check(@RequestParam("result") String result,HttpSession session){
        String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
        if(result.equals(random)){
            return  "success";
        }
        else return "fail";
    }

}
