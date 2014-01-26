/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.service;


import com.sprsec.dao.CouponDAO;
import com.sprsec.model.Coupon;
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
public class CouponServiceImpl implements CouponService{
    
  @Autowired
  private CouponDAO couponDAO;

    public List<Coupon> getCouponListByValue(int parseInt) {
        return couponDAO.getCouponListByValue(parseInt);
    }


}
