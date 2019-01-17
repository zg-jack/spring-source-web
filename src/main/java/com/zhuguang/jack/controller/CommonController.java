package com.zhuguang.jack.controller;

import com.zhuguang.jack.bean.ConsultContent;
import com.zhuguang.jack.scope.ScopeTest;
import com.zhuguang.jack.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/common")
public class CommonController {

    @Autowired
    ScopeTest scopeTest;

    @Autowired
    @Qualifier("annotationServiceImpl")
    MyService myService;

    @RequestMapping("/index")
    public @ResponseBody
    String index() {
        System.out.println(scopeTest.getUsername());
        return "ok" + scopeTest.getUsername();
    }

    @RequestMapping("/queryContent")
    public @ResponseBody
    List<ConsultContent> queryContent() {
        return myService.queryContent(new HashMap());
    }
}
