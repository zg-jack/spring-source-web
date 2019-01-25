package com.zhuguang.jack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/queryUser")
    public @ResponseBody String queryUser(String param) {
        System.out.println("============" + this.getClass().getName());
        return "Ok";
    }
}
