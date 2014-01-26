/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author kiran
 */
@Entity
@Table(name="manager")
public class Manager implements Serializable {
    @Id
    @Column(name = "mid")
     private Integer mid;
    @Id
    @Column(name = "buhid")
     private Integer buhid;

    public Integer getBuhid() {
        return buhid;
    }

    public void setBuhid(Integer buhid) {
        this.buhid = buhid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }
    
}
