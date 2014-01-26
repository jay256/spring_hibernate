/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.service;

import com.sprsec.model.Coupon;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface CouponService {

    public List<Coupon> getCouponListByValue(int parseInt);


}
