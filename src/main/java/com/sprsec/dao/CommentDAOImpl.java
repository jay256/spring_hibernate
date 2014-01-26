/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.dao;

import com.sprsec.model.Comment;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL
 */
@Repository
public class CommentDAOImpl implements CommentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    public List<Comment> getComment(int cid) {
        List<Comment> commentList = new ArrayList<Comment>();
        Query query = openSession().createQuery("from Comment c where c.commented_on = :cid order by c.cid DESC");
        query.setParameter("cid", cid);
        query.setMaxResults(4);
        commentList = query.list();
        if (commentList.size() > 0) {
            return commentList;
        } else {
            return new ArrayList<Comment>();
        }
    }

    public void addComment(Integer commentedBy, int parseInt, String comment) {
        Comment c = new Comment();
        c.setCommented_by(commentedBy);
        c.setCommented_on(parseInt);
        c.setComment(comment);
        c.setTime(CommentDAOImpl.getCurrentTimeStamp());
        openSession().save(c);
    }

    public void deleteComment(int parseInt) {
        Query query = openSession().createQuery("delete from Comment c where c.cid=:cid");
        query.setParameter("cid", parseInt);
        int result = query.executeUpdate();
    }
}
