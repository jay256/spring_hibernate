/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.dao;

import com.sprsec.model.Coupon;
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
public class CouponDAOImpl implements CouponDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<Coupon> getCouponListByValue(int parseInt) {
        List<Coupon> coupons = new ArrayList<Coupon>();
        Coupon c = new Coupon();
        int noc = parseInt / 500;
        for (int i = 0; i< noc; i++){
            Query query = openSession().createQuery("from Coupon c2 where c2.couponid = some(select MIN(couponid) from Coupon c where c.status = 0)");
            c = (Coupon) query.list().get(0);
            coupons.add(c);
            c.setStatus(1);
        }
        return coupons;
    }

}