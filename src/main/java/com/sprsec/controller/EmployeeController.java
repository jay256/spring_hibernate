package com.sprsec.controller;

import com.sprsec.model.Approval;
import com.sprsec.model.AwardScheme;
import com.sprsec.model.Comment;
import com.sprsec.model.Nomination;
import com.sprsec.model.User;
import com.sprsec.service.ApprovalService;
import com.sprsec.service.AwardSchemeService;
import com.sprsec.service.CommentService;
import com.sprsec.service.CustomUser;
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

@Controller
@RequestMapping(value = "/userpage")
public class EmployeeController {

    private UserService userService;
    private CommentService commentService;
    private ApprovalService approvalservice;
    private NominationsService nominationService;
    private AwardSchemeService awardSchemeService;

    public AwardSchemeService getAwardSchemeService() {
        return awardSchemeService;
    }

    @Autowired
    public void setAwardSchemeService(AwardSchemeService awardSchemeService) {
        this.awardSchemeService = awardSchemeService;
    }

    public NominationsService getNominationService() {
        return nominationService;
    }

    @Autowired
    public void setNominationService(NominationsService nominationService) {
        this.nominationService = nominationService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public ApprovalService getApprovalservice() {
        return approvalservice;
    }

    @Autowired
    public void setApprovalservice(ApprovalService approvalservice) {
        this.approvalservice = approvalservice;
    }

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    public CommentService getCommentService() {
        return commentService;
    }

    public ModelAndView getModelAndView(String viewName) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView mv = new ModelAndView(viewName);
        BigInteger phone;
        String username;
        Integer id;
        String dob;
        String emp_role;
        float rating;
        int i;
        float j;
        Integer k = 0 ;
        List<Comment> comments;
        List<Nomination> approvedNominations = new ArrayList<Nomination>();
        int listsize;
        List<User> recentbdays = new ArrayList<User>();
        Map<User, Nomination> recentawards = new HashMap<User, Nomination>();
        if (principal instanceof CustomUser) {
            username = ((CustomUser) principal).getName();
            id = ((CustomUser) principal).getId();
            dob = ((CustomUser) principal).getDOB();
            rating = ((CustomUser) principal).getRating();
            i = (int) Math.floor(rating);
            j = rating - i;
            j = j * 10;
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
            comments = commentService.getComment(id);
            approvedNominations = approvalservice.getApprovalList(id);
            listsize = approvedNominations.size();
            recentbdays = userService.getRecentBdays();
            List<Approval> approves = approvalservice.recentAwards();
            for (Approval approval : approves) {
                recentawards.put(userService.getUserByNid(approval.getNid()), nominationService.getNomination(approval.getNid()));
            }
        } else {
            username = null;
            id = null;
            dob = null;
            rating = 0f;
            emp_role = null;
            phone = null;
            comments = null;
            listsize = 0;
            i = 0;
            j = 0;
            k = 0;
            recentbdays = null;
            recentawards = null;
        }
        mv.addObject("aname", username);
        mv.addObject("emp_id", id);
        mv.addObject("dob", dob);
        mv.addObject("rating", rating);
        mv.addObject("role", emp_role);
        mv.addObject("phone", phone);
        mv.addObject("comments", comments);
        mv.addObject("approvedNomination", approvedNominations);
        mv.addObject("listsize", listsize);
        mv.addObject("fullstar", i);
        mv.addObject("decimalstar", k.toString());
        mv.addObject("recentawards", recentawards);
        mv.addObject("recentbdays", recentbdays);
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView userPage() {
        this.setRating();
        return getModelAndView("userpage");
    }

    public void setRating() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String date = ((CustomUser) principal).getDoj();
        String time = " 00:00:00";
        String doj = date + time;
        Integer eid = ((CustomUser) principal).getId();
        List<AwardScheme> as = awardSchemeService.getAllAwardSchemes();
        float a = 0, n = 0, w = 0, A = 0, N = 0, a_pre = 0, n_pre = 0, w_pre = 0;
        Float rating;
        for (AwardScheme aws : as) {
            N = (float) nominationService.getNominationCountByDojandAwardScheme(doj, aws.getAwardName());
            n_pre = (float) nominationService.getNominationCountByAwardScheme(eid, aws.getAwardName());
            w_pre = aws.getCredits();
            if (N != 0) {
                A = (float) approvalservice.getApprovalCountByDojandAwardScheme(doj, aws.getAwardName());
                a_pre = (float) approvalservice.getApprovalCountByAwardScheme(eid, aws.getAwardName());
                if (A != 0) {
                    a += 2 * (a_pre / A) * w_pre * 100;
                }
                n += (n_pre / N) * w_pre * 100;
            }
            w += w_pre;
        }
        rating = (((a + n) / w) / 120);
        userService.setRating(2.5f + rating);
    }
}