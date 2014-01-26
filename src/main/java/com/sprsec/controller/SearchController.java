/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.controller;

import com.sprsec.model.AwardScheme;
import com.sprsec.model.Comment;
import com.sprsec.model.User;
import com.sprsec.service.CommentService;
import com.sprsec.service.CustomUser;
import com.sprsec.service.UserService;
import com.sprsec.service.SearchService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {

    private UserService userService;
    private SearchService searchService;
    private CommentService commentService;

    public CommentService getCommentService() {
        return commentService;
    }

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @Autowired
    public void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }

    public SearchService getSearchService() {
        return searchService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchPage(@RequestParam("name1") String name) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int pid = ((CustomUser) principal).getId();
        ModelAndView mav = new ModelAndView("searchresults");
        List<User> searchstring = searchService.searchResults(name, pid);
        mav.addObject("searchresults", searchstring);
        mav.addObject("key", name);
        return mav;

    }

    @RequestMapping(value = "/viewprofile/{id}", method = RequestMethod.GET)
    public ModelAndView viewProfile(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mv = new ModelAndView("viewprofile");
        List<Comment> comments = commentService.getComment(id);
        User user = new User();
        user = userService.getUserByID(id);
        float rating = user.getRating();
        int i;
        float j;
        Integer k = 0;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int pid = ((CustomUser) principal).getId();
        if (pid == id) {
            response.sendRedirect(request.getContextPath() + "/userpage");
            return new ModelAndView("userpage");
        } else {
            i = (int) Math.floor(rating);
            j = rating - i;
            j = j * 10;
            if (j <= 0.5f) {
                k = 0;
            } else if (j > 0.5f && j <= 1.5) {
                k = 1;
            } else if (j > 1.5 && j <= 2.5) {
                k = 2;
            } else if (j > 2.5 && j <= 3.5) {
                k = 3;
            } else if (j > 3.5 && j <= 4.5) {
                k = 4;
            } else if (j > 4.5 && j <= 5.5) {
                k = 5;
            } else if (j > 5.5 && j <= 6.5) {
                k = 6;
            } else if (j > 6.5 && j <= 7.5) {
                k = 7;
            } else if (j > 7.5 && j <= 8.5) {
                k = 8;
            } else if (j > 8.5 && j <= 9.5) {
                k = 9;
            } else if (j > 9.5) {
                k = 0;
            }
            mv.addObject("emp_id", user.getId());
            mv.addObject("aname", user.getName());
            mv.addObject("dob", user.getDob());
            mv.addObject("rating", user.getRating());
            mv.addObject("role", user.getEmp_role());
            mv.addObject("username", user.getUsername());
            mv.addObject("comments", comments);
            mv.addObject("fullstar", i);
            mv.addObject("decimalstar", k.toString());
            return mv;
        }
    }

    @RequestMapping(value = "/admin/searchadmin", method = RequestMethod.GET)
    public ModelAndView searchPageadmin(@RequestParam("name1") String name) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int pid = ((CustomUser) principal).getId();
        ModelAndView mav = new ModelAndView("employeedb");
        List<User> searchstring = searchService.searchResults(name, pid);
        mav.addObject("searchresults", searchstring);
        return mav;

    }

    @RequestMapping(value = "/admin/searchadminscheme", method = RequestMethod.POST)
    public ModelAndView searchPageadmi(@RequestParam("name1") String name) {

        ModelAndView mav = new ModelAndView("adminpage");
        List<AwardScheme> searchstring = searchService.schemeResults(name);
        mav.addObject("allschemes", searchstring);
        return mav;

    }
}
