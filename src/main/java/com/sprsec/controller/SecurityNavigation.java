package com.sprsec.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityNavigation {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mv =  new ModelAndView("startpage");
        return mv;
    }
    
    @RequestMapping(value = "/login-form", method = RequestMethod.GET)
    public ModelAndView loginForm1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mv =  new ModelAndView("login-form");
        return mv;
    }

    @RequestMapping(value = "/error-login", method = RequestMethod.GET)
    public ModelAndView invalidLogin() {
        ModelAndView modelAndView = new ModelAndView("login-form");
        modelAndView.addObject("error", true);
        return modelAndView;
    }

    @RequestMapping(value = "/success-login", method = RequestMethod.GET)
    public ModelAndView successLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mv =  new ModelAndView("userpage");
        return mv;
    }
}
