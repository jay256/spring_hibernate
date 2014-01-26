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
@Table(name = "bu_head")
public class BUH implements Serializable {

    @Id
    @Column(name = "buhid")
    private Integer buhid;

    public Integer getBuhid() {
        return buhid;
    }

    public void setBuhid(Integer buhid) {
        this.buhid = buhid;
    }
}