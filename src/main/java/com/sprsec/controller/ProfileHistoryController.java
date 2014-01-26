/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.controller;

import com.sprsec.model.Nomination;
import com.sprsec.service.ApprovalService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author DELL
 */
@Controller
public class ProfileHistoryController {
    
    private ApprovalService approvalService;

    public ApprovalService getApprovalService() {
        return approvalService;
    }

    @Autowired
    public void setApprovalService(ApprovalService approvalService) {
        this.approvalService = approvalService;
    }
    
    @RequestMapping(value = "viewprofile/history/{id}",method = RequestMethod.GET)
    public ModelAndView profileHistory(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mv = new ModelAndView("history");
        List<Nomination> allApprovedNominations = approvalService.getAllApprovednominations(id);
        mv.addObject("allapprovals", allApprovedNominations);
        return mv;
    }
}
