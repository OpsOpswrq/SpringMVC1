package com.feng.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feng.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/test1")
public class HelloController1 {
    @RequestMapping("/t1")
    public String test1() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        User feng = new User(1, "feng", 3);
        String s = objectMapper.writeValueAsString(feng);
        User user = objectMapper.readValue(s, User.class);
        System.out.println(user);
        return s;
    }
    @RequestMapping("/t2")
    @ResponseBody
    public boolean test2(){
        return true;
    }
    @RequestMapping("/t3")
    public User test3(){
        User feng = new User(1, "feng", 4);
        return feng;
    }
    @RequestMapping(value = "/t4",produces = "application/json;charset=utf-8")
    public String test4() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        User feng = new User(1, "枫", 4);
        User feng1 = new User(2, "feng", 5);
        ArrayList<User> users = new ArrayList<>();
        users.add(feng);
        users.add(feng1);
        String s = objectMapper.writeValueAsString(users);
        List<User> ans = objectMapper.readValue(s,new TypeReference<List<User>>(){});
        for (User an : ans) {
            System.out.println(an);
        }
        return s;
    }
    @RequestMapping("/t5")
    public String test5(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        return format;
    }
}
