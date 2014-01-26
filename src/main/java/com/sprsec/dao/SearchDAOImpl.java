/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.dao;

import com.sprsec.model.AwardScheme;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sprsec.model.User;
// import java.math.BigInteger;

@Repository
public class SearchDAOImpl implements SearchDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<User> searchResults(String random, int pid) {
        String temp = "%" + random + "%";
        List<User> searchRes = new ArrayList<User>();
        Query query = openSession().createQuery("from User u where u.name like :temp and u.id <> :id");
        query.setParameter("temp", temp);
        query.setParameter("id", pid);
        searchRes = query.list();
        if (searchRes.size() > 0) {
            return searchRes;
        } else {
            try {
                int tempo = Integer.parseInt(random);
            } catch (NumberFormatException e) {

                return null;
            }
            int tempo = Integer.parseInt(random);
            Query query1 = openSession().createQuery("from User t where t.id like CONCAT('%', :temp1 ,'%') and t.id <> :id1");
            query1.setParameter("temp1", tempo);
            query1.setParameter("id1", pid);
            List<User> searchRes1 = new ArrayList<User>();
            searchRes1 = query1.list();

            if (searchRes1.size() > 0) {
                return searchRes1;

            } else {
                return null;
            }
        }

    }

    public List<AwardScheme> schemeResults(String name) {
        List<AwardScheme> award = new ArrayList<AwardScheme>();
        String name1 = "%" + name + "%";
        Query query = openSession().createQuery("from AwardScheme a where a.awardName like :name");
        query.setParameter("name", name1);
        award = query.list();
        if (award.size() > 0) {
            return award;
        } else {
            return null;
        }
    }
}
