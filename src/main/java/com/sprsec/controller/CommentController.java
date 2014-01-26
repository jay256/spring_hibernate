/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.controller;

import com.sprsec.service.CommentService;
import com.sprsec.service.CustomUser;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author DELL
 */
@Controller
public class CommentController {

    private CommentService commentService;

    public CommentService getCommentService() {
        return commentService;
    }

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(value = "/viewprofile/viewercomment", method = RequestMethod.POST)
    public void addComment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String comment = request.getParameter("comment");
        String commentedOn = request.getParameter("commenton");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer commentedBy = ((CustomUser) principal).getId();
        if (comment != null && !"".equals(comment)) {
            commentService.addComment(commentedBy, Integer.parseInt(commentedOn), comment);
        }
        response.sendRedirect(request.getContextPath() + "/viewprofile/" + commentedOn);
    }

    @RequestMapping(value = "deletecomment", method = RequestMethod.POST)
    public void deleteComment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cid = request.getParameter("cid");
        if (cid != null) {
            commentService.deleteComment(Integer.parseInt(cid));
        }
        response.sendRedirect(request.getContextPath() +"/userpage");
    }
}
