package com.zhuguang.jack.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NameController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("===============NameController.handleRequestInternal");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ok");
        return modelAndView;
    }
}
