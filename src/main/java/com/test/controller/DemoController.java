package com.test.controller;


import com.alibaba.fastjson.JSON;
import com.test.domain.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


//Restful接口的写法，注意这种写法和Get的写法在url地址栏的写法的区别：xxx?name=张三&age=23和localhost:8080//demo/test/孙七/23的区别
//该种写法就是用来替代servlet接口，可以把servlet接口写在一起
@Controller
@RequestMapping("/demo")
public class DemoController  {

    @RequestMapping("/test")
    public String index(){
        return "test";
    }

    @RequestMapping("/jsp")
    public String getJsp(){
        return "testing";
    }

    @RequestMapping(value = "/json",method = RequestMethod.POST,
            produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String getJson(){
        UserBean userBean = new UserBean();
        userBean.setName("张三");
        userBean.setAge(13);
        userBean.setSex("男");
        return JSON.toJSONString(userBean);
    }

    @RequestMapping(value = "/tests",produces = {"application/json;charset=utf-8"})
    public @ResponseBody String returnJson(){
        UserBean userBean = new UserBean();
        userBean.setName("王五");
        userBean.setAge(22);
        userBean.setSex("男");
        return JSON.toJSONString(userBean);
    }

    @RequestMapping(value = "/test/{age}",method = RequestMethod.GET,produces = {"application/json;charset=utf-8"})
    public @ResponseBody String returnJsons(@PathVariable int age){
        UserBean userBean = new UserBean();
        userBean.setSex("男");
        userBean.setAge(age);
        userBean.setName("马六'");
        return JSON.toJSONString(userBean);
    }

    @RequestMapping(value = "/test/{name}/{age}",produces = "application/json;charset=utf-8")
    public @ResponseBody String jsonReturn(@PathVariable("name") String username,@PathVariable("age") int userage){
        UserBean userBean = new UserBean();
        userBean.setName(username);
        userBean.setAge(userage);
        return JSON.toJSONString(userBean);
    }
}
