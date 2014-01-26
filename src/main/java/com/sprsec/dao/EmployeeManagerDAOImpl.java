/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.dao;

import com.sprsec.model.EmployeeManager;
import com.sprsec.model.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL
 */
@Repository
public class EmployeeManagerDAOImpl implements EmployeeManagerDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public List<User> getEmployee(int mid){
        List<User> userList = new ArrayList<User>();
        Query query = openSession().createQuery("from User u where u.id = some(select em.eid from EmployeeManager em where em.mid = :mid)")
                                   .setParameter("mid", mid);
                                   
                                        
        userList = query.list();
        if(userList.size()>0){
            return userList;
        }
        else
            return new ArrayList<User>();  
    }
}
