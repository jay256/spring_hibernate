/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.service;

import com.sprsec.dao.CommentDAO;
import com.sprsec.model.Comment;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentDAO commentDAO;
    public List<Comment> getComment(int cid){
        return commentDAO.getComment(cid);
    }

    public void addComment(Integer commentedBy, int parseInt, String comment) {
        commentDAO.addComment(commentedBy,parseInt,comment);
    }

    public void deleteComment(int parseInt) {
        commentDAO.deleteComment(parseInt);
    }
}
