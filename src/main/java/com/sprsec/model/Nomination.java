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
@Table(name="nomination")
public class Nomination implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "nid")
     private Integer nid;
    @Column(name = "mid")
     private Integer mid;
    @Column(name = "eid")
     private Integer eid;
    @Column(name = "aname")
     private String aname;
    @Column(name = "status")
    private int status;
    @Column(name = "time")
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }    
}
