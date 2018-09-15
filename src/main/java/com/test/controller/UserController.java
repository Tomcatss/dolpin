package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.test.domain.UserBean;
import com.test.pojo.UserPojo;
import com.test.service.Iservice.IUserService;
import com.test.service.serviceImp.UserServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller//加了此注解即表示遵循mvc分层结构
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/checkUser", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String check(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String username = request.getParameter("username");
        UserBean userBean = new UserBean();
        userBean.setName(username);
        IUserService userService = new UserServiceImp();
        UserPojo userPojo = userService.findUser(userBean);
        return JSON.toJSONString(userPojo);
    }
}
