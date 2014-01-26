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
@Table(name="roles")
public class RoleId implements Serializable{
    @Id
    @Column(name="roleid")
            private int roleid;
    
    @Column(name="role")
            private int role;

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }
    
    
}
