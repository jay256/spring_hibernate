/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.service;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author DELL
 */
public class CustomUser extends User {

    private String name;
    private String dob;
    private Integer id;
    private float rating;
    private String emp_role;
    private String doj;

    public CustomUser(String username, String password, String name, String dob, Integer id, float rating, String emp_role,String doj, boolean enabled, boolean accountNonExpired,
            boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.name = name;
        this.id = id;
        this.dob = dob;
        this.rating = rating;
        this.emp_role = emp_role;
        this.doj = doj;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getDOB() {
        return dob;
    }

    public float getRating() {
        
        return rating;
    }

    public String getEmp_role() {
        return emp_role;
    }
    
    
    public String getDoj() {
        return doj;
    }
}
