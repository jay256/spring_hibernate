/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.dao;

import com.sprsec.model.Comment;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface CommentDAO {

    public List<Comment> getComment(int cid);

    public void addComment(Integer commentedBy, int parseInt, String comment);

    public void deleteComment(int parseInt);
}
