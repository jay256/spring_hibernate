/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.controller;

import com.sprsec.service.UserService;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author DELL
 */
@Controller
@RequestMapping(value = "/dbresources/images")
public class ImageController {

    @Autowired
    private UserService userService; // a service to retrieve pictures fomr DB

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // getters and setters
    @RequestMapping(value = "/{id}")
    public void writePicture(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            byte[] img = userService.getPicture(id);
            if (img.length != 0) {
                response.setContentLength(img.length);
                response.getOutputStream().write(img);
                response.setStatus(HttpServletResponse.SC_OK);
            }
            else{}
                
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404. Add specific catch for specific errors
        }
    }
}
