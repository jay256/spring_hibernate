package com.sprsec.dao;

import com.sprsec.model.EmployeeManager;
import com.sprsec.model.Manager;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sprsec.model.User;
import com.sprsec.service.CustomUser;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.security.core.context.SecurityContextHolder;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    public User getUser(String login) {
        List<User> userList = new ArrayList<User>();
        Query query = openSession().createQuery("from User u where u.username = :login");
        query.setParameter("login", login);
        userList = query.list();
        if (userList.size() > 0) {
            return userList.get(0);
        } else {
            return new User();
        }
    }

    public BigInteger getPhone(int id) {
        List<User> userList = new ArrayList<User>();
        Query query = openSession().createQuery("from User u where u.id = :id");
        query.setParameter("id", id);
        userList = query.list();
        if (userList.size() > 0) {
            return userList.get(0).getPhone();
        } else {
            return null;
        }
    }

    public byte[] getPicture(int id) {
        List<User> userList = new ArrayList<User>();
        Query query = openSession().createQuery("from User u where u.id = :id");
        query.setParameter("id", id);
        userList = query.list();
        if (userList.size() > 0) {
            return userList.get(0).getPicture();
        } else {
            return null;
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<User>();
        Query query = openSession().createQuery("from User u where u.id != 11111 ");
        userList = query.list();
        if (userList.size() > 0) {
            return userList;
        } else {
            return new ArrayList<User>();
        }
    }

    public User getUserByID(int id) {
        List<User> userList = new ArrayList<User>();
        Query query = openSession().createQuery("from User u where u.id = :id");
        query.setParameter("id", id);
        userList = query.list();
        if (userList.size() > 0) {
            return userList.get(0);
        } else {
            return new User();
        }
    }

    public void setRating(float parseFloat) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int id = ((CustomUser) principal).getId();
        Query query = openSession().createQuery("update User u set u.rating=:rating where u.id=:id");
        query.setParameter("id", id);
        query.setParameter("rating", parseFloat);
        int executeUpdate = query.executeUpdate();
    }

    public User getUserByNid(int id) {
        List<User> userlist = new ArrayList<User>();
        Query query = openSession().createQuery("from User u where u.id = some (select n.eid from Nomination n where n.nid = :id)");
        query.setParameter("id", id);
        userlist = query.list();
        return userlist.get(0);
    }

    public List<User> getRecentBdays() {
        List<User> usrlist = new ArrayList<User>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String dt = dateFormat.format(date);
        String dtparts[] = dt.split("/");
        Query query = openSession().createQuery("from User u where u.dob like CONCAT('%', :temp1 ,'-', :temp2)");

        query.setParameter("temp2", dtparts[2]);
        query.setParameter("temp1", dtparts[1]);
        usrlist = query.list();
        if (usrlist.size() > 0) {
            return usrlist;
        } else {
            return new ArrayList<User>();
        }
    }

    public void empUnderMngr(String[] mngrs, int eid) {
        String[] mngrlist = mngrs;
        int len = mngrlist.length;
        Query query = openSession().createQuery("delete from EmployeeManager em where em.eid = :var");
        query.setParameter("var", eid);
        int result = query.executeUpdate();
        for (int i = 0; i < len; i++) {

            EmployeeManager e = new EmployeeManager();
            e.setEid(eid);
            e.setMid(Integer.parseInt(mngrlist[i]));
            openSession().save(e);

        }
    }

    public void mngrsUnderBUH(String[] mngrs, int eid) {
        String[] mngrlist = mngrs;
        int len = mngrlist.length;

        for (int i = 0; i < len; i++) {

            Query query = openSession().createQuery("update Manager m set m.buhid = :bid where m.mid = :var");
            Query query1 = openSession().createQuery("update EmployeeManager em set em.mid = :bid where em.eid = :var");
            query.setParameter("var", Integer.parseInt(mngrlist[i]));
            query.setParameter("bid", eid);
            query1.setParameter("var", Integer.parseInt(mngrlist[i]));
            query1.setParameter("bid", eid);
            int result = query.executeUpdate();
            int result1 = query1.executeUpdate();

            if (result <= 0) {
                Manager e = new Manager();
                e.setBuhid(eid);
                e.setMid(Integer.parseInt(mngrlist[i]));
                openSession().save(e);
            }
            if (result1 <= 0) {
                EmployeeManager em = new EmployeeManager();
                em.setEid(Integer.parseInt(mngrlist[i]));
                em.setMid(eid);
                openSession().save(em);
            }


        }
    }

    public void newManager(int mid, int bid, String[] eids, boolean radio, boolean emptable) {


        if (emptable) {

            Query query = openSession().createQuery("delete from EmployeeManager e where e.mid = :var");
            query.setParameter("var", mid);
            int res = query.executeUpdate();
            for (String s : eids) {
                EmployeeManager em = new EmployeeManager();
                em.setEid(Integer.parseInt(s));
                em.setMid(mid);
                openSession().save(em);
            }
        }
        if (radio == true) {
            Query query = openSession().createQuery("update Manager m set m.buhid = :bid where m.mid = :var");
            Query query1 = openSession().createQuery("update EmployeeManager em set em.mid = :bid where em.eid = :var");
            query.setParameter("var", mid);
            query.setParameter("bid", bid);
            query1.setParameter("var", mid);
            query1.setParameter("bid", bid);
            int res1 = query.executeUpdate();
            int res2 = query1.executeUpdate();
            if (res1 <= 0) {
                Manager m = new Manager();
                m.setBuhid(bid);
                m.setMid(mid);
                openSession().save(m);
            }
            if (res2 <= 0) {
                EmployeeManager em = new EmployeeManager();
                em.setEid(mid);
                em.setMid(bid);
                openSession().save(em);
            }
        }
    }
}
