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
 * @author kiran
 */
@Entity
@Table(name = "emp_role")
public class EmpRole implements Serializable {

    @Id
    @Column(name = "eid")
    private int eid;
    @Column(name = "roleid")
    private int roleid;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }
}
