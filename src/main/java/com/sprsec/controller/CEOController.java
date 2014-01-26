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
import com.sprsec.service.BuhService;
import com.sprsec.service.CustomUser;
import com.sprsec.service.NominationsService;
import com.sprsec.service.UserService;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class CEOController {

    private UserService userService;
    private NominationsService nominationsService;
    private BuhService buhService;
    private AwardSchemeService awardSchemeService;
    private ApprovalService approvalService;

    public ApprovalService getApprovalService() {
        return approvalService;
    }

    @Autowired
    public void setApprovalService(ApprovalService approvalService) {
        this.approvalService = approvalService;
    }

    public AwardSchemeService getAwardSchemeService() {
        return awardSchemeService;
    }

    @Autowired
    public void setAwardSchemeService(AwardSchemeService awardSchemeService) {
        this.awardSchemeService = awardSchemeService;
    }

    @Autowired
    public void setBuhService(BuhService buhService) {
        this.buhService = buhService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setNominationsService(NominationsService nominationsService) {
        this.nominationsService = nominationsService;
    }

    public NominationsService getNominationsService() {
        return nominationsService;
    }

    public BuhService getBuhService() {
        return buhService;
    }

    public ModelAndView getModelAndView(String viewName) {
        ModelAndView mv = new ModelAndView(viewName);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        BigInteger phone;
        String username;
        Integer id;
        String dob;
        float rating;
        String emp_role;
        List<User> allusers;
        List<AwardScheme> awardSchemes;
        List<User> recentbdays = new ArrayList<User>();
        Map<User, Nomination> recentawards = new HashMap<User, Nomination>();
        if (principal instanceof CustomUser) {
            username = ((CustomUser) principal).getName();
            id = ((CustomUser) principal).getId();
            dob = ((CustomUser) principal).getDOB();
            rating = ((CustomUser) principal).getRating();
            emp_role = ((CustomUser) principal).getEmp_role();
            phone = userService.getPhone(id);
            awardSchemes = awardSchemeService.getAllAwardSchemes();
            recentbdays = userService.getRecentBdays();
            List<Approval> approves = approvalService.recentAwards();
            for (Approval approval : approves) {
                recentawards.put(userService.getUserByNid(approval.getNid()), nominationsService.getNomination(approval.getNid()));
            }
        } else {
            username = null;
            id = null;
            dob = null;
            rating = 0;
            emp_role = null;
            phone = null;
            awardSchemes = null;
            recentbdays = null;
            recentawards = null;
        }
        mv.addObject("aname", username);
        mv.addObject("emp_id", id);
        mv.addObject("dob", dob);
        mv.addObject("rating", rating);
        mv.addObject("role", emp_role);
        mv.addObject("phone", phone);
        mv.addObject("awardschemes", awardSchemes);
        mv.addObject("recentawards", recentawards);
        mv.addObject("recentbdays", recentbdays);
        return mv;
    }

    @RequestMapping(value = "/ceo/rewardall", method = RequestMethod.GET)
    public ModelAndView nominateManagers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mv = null;
        mv = getModelAndView("rewardall");
        List<User> alluser = userService.getAllUsers();
        mv.addObject("allusers", alluser);
        return mv;
    }

    @RequestMapping(value = "/ceo/selectedusers", method = RequestMethod.GET)
    public void rewardManagers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String buhid = request.getParameter("ceoid");
        String awardScheme = request.getParameter("awardscheme");
        String[] id = request.getParameterValues("users");
        if (id != null) {
            for (String str : id) {
                nominationsService.addNominatedManager(Integer.parseInt(buhid), Integer.parseInt(str), awardScheme);
            }
        }
        response.sendRedirect(request.getContextPath() + "/ceo/rewardall");
    }
}
