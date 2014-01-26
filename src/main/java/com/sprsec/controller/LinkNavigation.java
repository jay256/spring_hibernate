package com.sprsec.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkNavigation {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void indexPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("home");
    }
    
    
}
