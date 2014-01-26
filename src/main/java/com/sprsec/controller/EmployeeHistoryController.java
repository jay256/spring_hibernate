/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.controller;

import com.sprsec.model.Nomination;
import com.sprsec.service.ApprovalService;
import com.sprsec.service.CustomUser;
import java.util.List;
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
@RequestMapping(value="/userhistory")
public class EmployeeHistoryController {
    
    private ApprovalService approvalService;

    public ApprovalService getApprovalService() {
        return approvalService;
    }

    @Autowired
    public void setApprovalService(ApprovalService approvalService) {
        this.approvalService = approvalService;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView userHistory(){
        ModelAndView mv = new ModelAndView("userhistory");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer eid = ((CustomUser)principal).getId();
        List<Nomination> allApprovedNominations = approvalService.getAllApprovednominations(eid);
        mv.addObject("allapprovals", allApprovedNominations);
        return mv;
    }
}
