package com.sprsec.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue
    @Column(name="roleid")
    private Integer id;
    @Column(name="role")
    private String role;
   @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "emp_role",
            joinColumns = {
        @JoinColumn(name = "roleid", referencedColumnName = "roleid")},
            inverseJoinColumns = {
        @JoinColumn(name = "eid", referencedColumnName = "eid")})
    private Set<User> userRoles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<User> userRoles) {
        this.userRoles = userRoles;
    }
}
