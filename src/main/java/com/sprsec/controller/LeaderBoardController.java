/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.controller;

import com.sprsec.model.User;
import com.sprsec.service.CustomUser;
import com.sprsec.service.LeaderBoardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LeaderBoardController {

    private LeaderBoardService leaderBoardService;

    public LeaderBoardService getLeaderBoardService() {
        return leaderBoardService;
    }

    @Autowired
    public void setLeaderBoardService(LeaderBoardService leaderBoardService) {
        this.leaderBoardService = leaderBoardService;
    }

    @RequestMapping(value = "/leaderboard", method = RequestMethod.GET)
    public ModelAndView leaderBoard() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String role = ((CustomUser) principal).getEmp_role();
        ModelAndView mav = new ModelAndView("leaderboard");
        List<User> m = leaderBoardService.getSortedMNGRList();
        List<User> e = leaderBoardService.getSortedEMPList();
        if (role.equals("EMP")) {
            mav.addObject("e", e);

        } else {
            mav.addObject("e", e);
            mav.addObject("m", m);
        }
        return mav;
    }
}
