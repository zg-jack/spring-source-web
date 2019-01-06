package com.zhuguang.jack.controller;

import com.zhuguang.jack.scope.ScopeTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/common")
public class CommonController {

    @Autowired
    ScopeTest scopeTest;

    @RequestMapping("/index")
    public @ResponseBody
    String index() {
        System.out.println(scopeTest.getUsername());
        return "ok" + scopeTest.getUsername();
    }
}
