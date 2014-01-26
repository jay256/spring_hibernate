/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.controller;

import com.sprsec.service.NominationsService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author DELL
 */
@Controller
@RequestMapping(value = "/manager/selectedusers")
public class ManagerNominationController {

    private NominationsService nominationService;

    public NominationsService getNominationService() {
        return nominationService;
    }

    @Autowired
    public void setNominationService(NominationsService nominationService) {
        this.nominationService = nominationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public void selectedUsersPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mid = request.getParameter("mid");
        String awardScheme = request.getParameter("awardscheme");
        String[] id = request.getParameterValues("users");

        if (id != null) {
            for (String str : id) {

                nominationService.addNomination(Integer.parseInt(mid), Integer.parseInt(str), awardScheme);
            }
        }
        
        response.sendRedirect("managerpage");
    }
}
