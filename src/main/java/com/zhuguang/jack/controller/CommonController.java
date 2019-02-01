package com.zhuguang.jack.controller;

import com.zhuguang.jack.bean.ConsultContent;
import com.zhuguang.jack.bean.User;
import com.zhuguang.jack.exception.PasswordCheckException;
import com.zhuguang.jack.scope.ScopeTest;
import com.zhuguang.jack.service.CacheServiceImpl;
import com.zhuguang.jack.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/common")
@SessionAttributes(value={ "intValue" , "hello" }, types={User. class })
public class CommonController {

    @Autowired
    ScopeTest scopeTest;

    @Autowired
    @Qualifier("annotationServiceImpl")
    MyService myService;

    /*
    content-type
    * username=jack&password=123&name=roy
    * json
    * {}
    *
    * /common/index
    * /common/index*
    * /commom/queryContent
    * /commom/queryContent*
    * /common/sayHello
    * /common/responseStatus
    *
    * */
    @RequestMapping("/index")
    public @ResponseBody
    String index() {
        System.out.println(scopeTest.getUsername());
        if(true) throw new RuntimeException("=======xxx");
        return "ok";
    }

    @RequestMapping("/queryContent")
    public @ResponseBody
    List<ConsultContent> queryContent() {
        return myService.queryContent(new HashMap());
    }

    @ModelAttribute("hello")
    public String getModel() {
        System.out.println("-------------Hello---------");
        return "world";
    }

    @ModelAttribute("intValue")
    public int getInteger() {
        System.out.println("-------------intValue---------------");
        return 10;
    }

    @RequestMapping("sayHello")
    public void sayHello(Map<String, Object> map, @ModelAttribute("hello") String hello,
                         @ModelAttribute("intValue") int num, @ModelAttribute("user2") User user,
                         PrintWriter writer, HttpServletRequest request) throws IOException {
        map.put("stringValue", "String");
        writer.write("Hello " + hello + " , Hello " + user.getUsername() + num);
        writer.println("\r\n");
        HttpSession session = request.getSession();
        Enumeration enume = session.getAttributeNames();
        while (enume.hasMoreElements()) {
            Object key = enume.nextElement();
            writer.write(key + ":" + session.getAttribute((String) key));
        }
        System.out.println(session);
    }

    @ModelAttribute("user2")
    public User getUser() {
        System.out.println("---------getUser-------------");
        User user = new User();
        user.setPassword("123");
        user.setUsername("Jack");
        user.setUid(114890);
        return user;
    }

    @RequestMapping("/responseStatus")
    public String responseStatus(@RequestParam("i") int i) {
        if(i == 1) {
            throw new PasswordCheckException();
        }
        System.out.println("============密码校验正确");
        return "ok";
    }

    @Autowired
    @Qualifier("cacheServiceImpl")
    MyService cacheService;

    @RequestMapping("/cache")
    public @ResponseBody String cacheTest(@RequestParam String param) {
        String result = cacheService.doSomething(param);
        System.out.println("=================result : " + result);
        return result;
    }

    @RequestMapping("/queryUser")
    public @ResponseBody String queryUser(@ModelAttribute("user2") User user) {
        User result = cacheService.queryUser(user);
        System.out.println("=================result : " + result);
        return "============ok==========";
    }
}
