package com.feng.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.feng.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/test2")
public class HelloController2 {
    @RequestMapping("/t2")
    @ResponseBody
    public String test1(){
        ArrayList<User> users = new ArrayList<>();
        User feng3 = new User(1, "feng", 3);
        User feng2 = new User(2, "feng", 3);
        User feng1 = new User(3, "feng", 3);
        User feng = new User(4, "feng", 3);
        users.add(feng1);
        users.add(feng2);
        users.add(feng3);
        String s1 = JSON.toJSONString(feng);
        User user = JSON.parseObject(s1, User.class);
        System.out.println(user);
        JSONObject o = (JSONObject) JSON.toJSON(user);
        System.out.println(o);
        String s = JSON.toJSONString(users);
        return s;
    }
}
