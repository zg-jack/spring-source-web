package com.zhuguang.jack.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BeanNameUrlController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("===========BeanNameUrlController==========");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ok");
        return modelAndView;
    }
}
