/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.controller;

import com.sprsec.model.Nomination;
import com.sprsec.model.User;
import com.sprsec.service.ApprovalService;
import com.sprsec.service.BuhService;
import com.sprsec.service.NominationsService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@RequestMapping(value = "/buh/approveduser")
public class ApprovalController {

    private ApprovalService approvalService;
    private BuhService buhService;
    private NominationsService nominationService;

    public NominationsService getNominationService() {
        return nominationService;
    }

    @Autowired
    public void setNominationService(NominationsService nominationService) {
        this.nominationService = nominationService;
    }

    public BuhService getBuhService() {
        return buhService;
    }

    @Autowired
    public void setBuhService(BuhService buhService) {
        this.buhService = buhService;
    }

    public ApprovalService getApprovalService() {
        return approvalService;
    }

    @Autowired
    public void setApprovalService(ApprovalService approvalService) {
        this.approvalService = approvalService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public void approvedUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String buhid = request.getParameter("buhid");
        String[] nid = request.getParameterValues("nominations");
        if (nid != null) {
            for (String s : nid) {
                approvalService.addNomination(Integer.parseInt(s), Integer.parseInt(buhid));
            }
            this.setNominationStatus(buhid);
        }
        
        response.sendRedirect("buhpage");
    }

    public void setNominationStatus(String buhid) {
        List<User> managers = buhService.getManagers(Integer.parseInt(buhid));
        List<Nomination> nominations = new ArrayList<Nomination>();
        for (User u : managers) {
            for (Nomination n : nominationService.getNominationByMid(u.getId())) {
                nominations.add(n);
            }
        }
        for (Nomination n : nominations) {
            nominationService.setStatusByNid(n.getNid());
        }

    }
    
    
}
