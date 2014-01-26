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
 * @author DELL
 */
@Repository
public class BuhDAOImpl implements BuhDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<User> getManagers(int buhid) {
        List<User> managers = new ArrayList<User>();
        Query query = openSession().createQuery("from User u where u.id = some(select m.mid from Manager m where m.buhid = :buhid)");
        query.setParameter("buhid",buhid);
        managers = query.list();
        if(managers.size()>0)
            return managers;
        else
            return new ArrayList<User>();
    }
}
