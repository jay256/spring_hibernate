/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.dao;

import com.sprsec.model.AwardScheme;
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
public class AwardSchemeDAOImpl implements AwardSchemeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<AwardScheme> getAllAwardSchemes() {
        List<AwardScheme> awardSchemes = new ArrayList<AwardScheme>();
        Query query = getCurrentSession().createQuery("from AwardScheme awardScheme");
        awardSchemes = query.list();
        if (awardSchemes.size() > 0) {
            return awardSchemes;
        } else {
            return new ArrayList<AwardScheme>();
        }
    }

    public Integer getValueByAname(String aname) {

        Query query = getCurrentSession().createQuery("select a.price from AwardScheme a where a.awardName =:aname");
        query.setParameter("aname", aname);
        return (Integer) query.list().get(0);

    }
}
