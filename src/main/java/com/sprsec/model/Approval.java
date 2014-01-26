/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "approves")
public class Approval implements Serializable {
    @Id
    @Column(name = "nid")
    private Integer nid;
    
    @Id
    @Column(name = "buhid")
    private Integer buhid;
    
    @Id
    @Column (name = "status")
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

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public Integer getBuhid() {
        return buhid;
    }

    public void setBuhid(Integer buhid) {
        this.buhid = buhid;
    }
}
