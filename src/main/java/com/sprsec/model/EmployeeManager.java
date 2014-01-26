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
 * @author DELL
 */
@Entity
@Table(name = "emp_mngr")
public class EmployeeManager implements Serializable {

    @Id
    @Column(name = "eid")
    private Integer eid;
    @Id
    @Column(name = "mid")
    private Integer mid;

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
}
