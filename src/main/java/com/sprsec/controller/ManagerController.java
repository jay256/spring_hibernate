/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.controller;

import com.sprsec.model.Approval;
import com.sprsec.model.AwardScheme;
import com.sprsec.model.Nomination;
import com.sprsec.model.User;
import com.sprsec.service.ApprovalService;
import com.sprsec.service.AwardSchemeService;
import com.sprsec.service.CustomUser;
import com.sprsec.service.EmployeeManagerService;
import com.sprsec.service.NominationsService;
import com.sprsec.service.UserService;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author DELL
 */
@Controller
@RequestMapping(value = "/manager/managerpage")
public class ManagerController {

    private UserService userService;
    private EmployeeManagerService emp_mngrService;
    private AwardSchemeService awardSchemeService;
    private NominationsService nominationsService;
    private ApprovalService approvalService;

    public NominationsService getNominationService() {
        return nominationsService;
    }

    @Autowired
    public void setNominationService(NominationsService nominationService) {
        this.nominationsService = nominationService;
    }

    public ApprovalService getApproalService() {
        return approvalService;
    }

    @Autowired
    public void setApproalService(ApprovalService approalService) {
        this.approvalService = approalService;
    }

    public AwardSchemeService getAwardSchemeService() {
        return awardSchemeService;
    }

    @Autowired
    public void setAwardSchemeService(AwardSchemeService awardSchemeService) {
        this.awardSchemeService = awardSchemeService;
    }

    public EmployeeManagerService getEmp_mngrService() {
        return emp_mngrService;
    }

    @Autowired
    public void setEmp_mngrService(EmployeeManagerService emp_mngrService) {
        this.emp_mngrService = emp_mngrService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    public ModelAndView getModelAndView(String viewName) {
        ModelAndView mv = new ModelAndView(viewName);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        BigInteger phone;
        String name;
        String username;
        Integer id;
        String dob;
        float rating;
        String emp_role;
        List<User> allUsers;
        List<AwardScheme> awardSchemes;
        List<User> recentbdays = new ArrayList<User>();
        int i=0;
        float j=0f;
        Integer k = 0;
        Map<User, Nomination> recentawards = new HashMap<User, Nomination>();
        if (principal instanceof CustomUser) {
            name = ((CustomUser) principal).getName();
            username = ((CustomUser) principal).getUsername();
            id = ((CustomUser) principal).getId();
            dob = ((CustomUser) principal).getDOB();
            rating = ((CustomUser) principal).getRating();
            i = (int)Math.floor(rating);
            j = rating - i;
            j = j*10;
            if(j<=0.5f)
                k=0;
            else if (j > 0.5f && j<=1.5)
                k = 1;
            else if(j>1.5 && j<=2.5)
                k = 2;
            else if(j>2.5 && j<=3.5)
                k=3;
            else if(j>3.5 && j<=4.5)
                k=4;
            else if(j>4.5 && j<=5.5)
                k=5;
            else if(j>5.5 && j<=6.5)
                k=6;
            else if(j>6.5 && j<=7.5)
                k=7;
            else if(j>7.5 && j<=8.5)
                k=8;
            else if(j>8.5 && j<=9.5)
                k=9;
            else if(j>9.5)   
                k = 0;
            
            
            emp_role = ((CustomUser) principal).getEmp_role();
            phone = userService.getPhone(id);
            allUsers = emp_mngrService.getEmployee(id);
            awardSchemes = awardSchemeService.getAllAwardSchemes();
            recentbdays = userService.getRecentBdays();
            List<Approval> approves = approvalService.recentAwards();
            for (Approval approval : approves) {
                recentawards.put(userService.getUserByNid(approval.getNid()), nominationsService.getNomination(approval.getNid()));
            }
        } else {
            name = null;
            id = null;
            dob = null;
            rating = 0;
            emp_role = null;
            phone = null;
            allUsers = null;
            username = null;
            awardSchemes = null;
            recentbdays = null;
            recentawards = null;
            i=0;
            j=0;
            k=0;
        }
        mv.addObject("aname", name);
        mv.addObject("emp_id", id);
        mv.addObject("dob", dob);
        mv.addObject("rating", rating);
        mv.addObject("role", emp_role);
        mv.addObject("phone", phone);
        mv.addObject("allusers", allUsers);
        mv.addObject("username", username);
        mv.addObject("awardschemes", awardSchemes);
        mv.addObject("recentawards",recentawards);
        mv.addObject("recentbdays",recentbdays);
        mv.addObject("fullstar", i);
        mv.addObject("decimalstar", k.toString());
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView managerPage() {
        return getModelAndView("managerpage");
    }
}
