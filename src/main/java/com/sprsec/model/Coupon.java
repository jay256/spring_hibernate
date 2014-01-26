/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "coupon")
public class Coupon {
    @Id
    @GeneratedValue
    @Column(name = "couponid")
    private Integer couponid;
    @Column(name = "coupon_no")
    private String coupon_no;
    @Column(name = "status")
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getCouponid() {
        return couponid;
    }

    public void setCouponid(Integer couponid) {
        this.couponid = couponid;
    }

    public String getCoupon_no() {
        return coupon_no;
    }

    public void setCoupon_no(String coupon_no) {
        this.coupon_no = coupon_no;
    }
    
}
