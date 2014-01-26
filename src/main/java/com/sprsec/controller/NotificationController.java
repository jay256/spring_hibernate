/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.controller;

import com.sprsec.model.Coupon;
import com.sprsec.model.User;
import com.sprsec.service.ApprovalService;
import com.sprsec.service.AwardSchemeService;
import com.sprsec.service.CouponService;
import com.sprsec.service.UserService;
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
public class NotificationController {

    private UserService userService;
    private ApprovalService approvalService;
    private AwardSchemeService awardschemeService;
    private CouponService couponService;

    public CouponService getCouponService() {
        return couponService;
    }

    @Autowired
    public void setCouponService(CouponService couponService) {
        this.couponService = couponService;
    }

    public AwardSchemeService getAwardschemeService() {
        return awardschemeService;
    }

    @Autowired
    public void setAwardschemeService(AwardSchemeService awardschemeService) {
        this.awardschemeService = awardschemeService;
    }

    public ApprovalService getApprovalService() {
        return approvalService;
    }

    @Autowired
    public void setApprovalService(ApprovalService approvalService) {
        this.approvalService = approvalService;
    }

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/notification1", method = RequestMethod.GET)
    public void notificationAccepted(HttpServletRequest request, HttpServletResponse response) throws IOException  {
        response.sendRedirect(request.getContextPath() + "/userpage");
    }

    @RequestMapping(value = "/notification", method = RequestMethod.POST)
    public ModelAndView couponPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mv = new ModelAndView("coupon");
        String approverID = request.getParameter("mid"); 
        String aname = request.getParameter("aname");
        String nid = request.getParameter("nid");
        String value = awardschemeService.getValueByAname(aname).toString();
        List<Coupon> coupons = couponService.getCouponListByValue(Integer.parseInt(value));       
        User u = userService.getUserByID(Integer.parseInt(approverID));
        mv.addObject("aname", aname);
        mv.addObject("approver", u);
        mv.addObject("nid", nid);
        mv.addObject("couponno", coupons);
        return mv;
    }

    @RequestMapping(value = "/notification/accepted", method = RequestMethod.GET)
    public void acceptApproval(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nid = request.getParameter("nid");
        if (nid != null || !"".equals(nid)) {
            approvalService.setStatus(Integer.parseInt(nid));
        }
        response.sendRedirect(request.getContextPath() + "/notification1");
    }
}
