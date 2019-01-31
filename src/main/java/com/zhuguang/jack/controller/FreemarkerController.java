package com.zhuguang.jack.controller;

import com.zhuguang.jack.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/free")
public class FreemarkerController {

    @RequestMapping("/home")
    public String home(Model model) {
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setUid(1);
        user1.setUsername("jack");
        user1.setPassword("123");
        list.add(user1);
        User user2 = new User();
        user2.setUid(2);
        user2.setUsername("jack2");
        user2.setPassword("1232");
        list.add(user2);
        User user3 = new User();
        user3.setUid(3);
        user3.setUsername("jack3");
        user3.setPassword("1233");
        list.add(user3);
        model.addAttribute("users",list);
        return "home.ftl";
    }
}
