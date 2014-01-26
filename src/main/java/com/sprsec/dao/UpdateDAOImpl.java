/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.dao;

import com.sprsec.model.User;
import com.sprsec.service.CustomUser;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class UpdateDAOImpl implements UpdateDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    public void uploadPicture(MultipartFile filepath) {
        List<User> tempo = new ArrayList<User>();
        int id;
        try {
            byte[] bfile = null;
            bfile = filepath.getBytes();

            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof CustomUser) {
                id = ((CustomUser) principal).getId();
            } else {
                id = 0;
            }

            Query query = openSession().createQuery("From User u where u.id = :id ");
            query.setParameter("id", id);
            tempo = query.list();
            tempo.get(0).setPicture(bfile);

        } catch (IOException ex) {
            Logger.getLogger(UpdateDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int changePassword(String newpwd, String oldpwd) {
        List<User> temp = new ArrayList<User>();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int id;

        if (principal instanceof CustomUser) {
            id = ((CustomUser) principal).getId();
        } else {
            id = 0;
        }

        Query query = openSession().createQuery("From User u where u.id= :id");
        query.setParameter("id", id);
        temp = query.list();


        String str = temp.get(0).getPassword();
        if (str.equals(oldpwd)) {
            temp.get(0).setPassword(newpwd);
            return 1;
        } else {
            return 0;
        }
    }

    public void changeNumber(String newnum) {

        List<User> temp = new ArrayList<User>();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int id;

        if (principal instanceof CustomUser) {
            id = ((CustomUser) principal).getId();
        } else {
            id = 0;
        }

        Query query = openSession().createQuery("From User u where u.id= :id");
        query.setParameter("id", id);
        temp = query.list();
        BigInteger bi = new BigInteger(newnum, 10);
        temp.get(0).setPhone(bi);
    }
}
