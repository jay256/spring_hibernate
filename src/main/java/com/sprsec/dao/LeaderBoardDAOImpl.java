/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.dao;

import com.sprsec.model.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sujata
 */
@Repository
public class LeaderBoardDAOImpl implements LeaderBoardDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<User> getSortedBUHList() {
        List<User> b = new ArrayList<User>();
        Query query = openSession().createQuery("From User u where u.emp_role = :role order by u.rating desc");
        query.setParameter("role", "BUH");
        b = query.list();
        if (b.isEmpty() == false) {
            return b;
        } else {
            return new ArrayList<User>();
        }
    }

    public List<User> getSortedEMPList() {
        List<User> e = new ArrayList<User>();
        Query query = openSession().createQuery("From User u where u.emp_role = :role order by rating desc");
        query.setParameter("role", "EMP");
        e = query.list();
        if (e.isEmpty() == false) {
            return e;
        } else {
            return new ArrayList<User>();
        }
    }

    public List<User> getSortedMNGRList() {
        List<User> m = new ArrayList<User>();
        Query query = openSession().createQuery("From User u where u.emp_role = :role order by rating desc");
        query.setParameter("role", "MNGR");
        m = query.list();
        if (m.isEmpty() == false) {
            return m;
        } else {
            return new ArrayList<User>();
        }
    }
}
