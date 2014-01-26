/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.dao;

import com.sprsec.model.AwardScheme;
import com.sprsec.model.BUH;
import com.sprsec.model.EmpRole;
import com.sprsec.model.EmployeeManager;
import com.sprsec.model.Manager;
import com.sprsec.model.User;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAOImpl implements AdminDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    public String addNewEmp(String name, String dob, String doj, BigInteger phonenum, String role) {

        Query query = openSession().createQuery("select u.id from User u  order by u.id DESC");
        
        List<Integer> numlist = new ArrayList<Integer>();
        numlist = query.list();
        int rid = 0;
        

        User u = new User();
        u.setId((numlist.get(0)) + 1);
        u.setUsername(Integer.toString((numlist.get(0)) + 1));
        u.setName(name);
        u.setPassword("123");
        u.setPicture(null);
        u.setDob(dob);
        u.setDoj(doj);
        u.setPhone(phonenum);
        u.setEmp_role(role);
        u.setRating(5);
        u.setEmail("xyz@pqr.com");
        
        openSession().save(u);
        EmployeeManager em = new EmployeeManager();
        em.setEid((numlist.get(0)) + 1);
        em.setMid(11111);
        openSession().save(em);
        if ("EMP".equals(role)) {
            rid = 4;
        } else if ("MNGR".equals(role)) {
            rid = 3;
        } else if ("BUH".equals(role)) {
            rid = 2;
            BUH b = new BUH();
            b.setBuhid((numlist.get(0)) + 1);
            openSession().save(b);
            Manager mng = new Manager();
            mng.setBuhid(11111);
            mng.setMid((numlist.get(0)) + 1);
            openSession().save(mng);
        } else {
            rid = 1;
        }
        EmpRole er = new EmpRole();
        er.setEid((numlist.get(0)) + 1);
        er.setRoleid(rid);
        openSession().save(er);
        return (Integer.toString((numlist.get(0)) + 1));

    }

    public List<AwardScheme> getAllSchemes() {
        Query query = openSession().createQuery("from AwardScheme a");
        List<AwardScheme> awardlist = new ArrayList<AwardScheme>();
        awardlist = query.list();
        return awardlist;
    }

    public int addNewScheme(String aname, String desc, int val, int credits) {
        Query query = openSession().createQuery("from AwardScheme a where a.awardName = :name");
        query.setParameter("name", aname);
        List<AwardScheme> awardlist = new ArrayList<AwardScheme>();
        awardlist = query.list();
        if (awardlist.size() > 0) {
            return 0;
        } else {
            AwardScheme a = new AwardScheme();
            a.setAwardName(aname);
            a.setDescription(desc);
            a.setPrice(val);
            a.setCredits(credits);
            openSession().save(a);
            return 1;
        }
    }

    public void deleteScheme(String aname) {
        Query query = openSession().createQuery("delete from AwardScheme a where a.awardName = :name ");
        query.setParameter("name", aname);
        int result = query.executeUpdate();
    }

    public void updateScheme(String aname, String desc, int val, int credits) {
        Query query = openSession().createQuery("update AwardScheme a set a.description = :desc where a.awardName= :name");
        Query query1 = openSession().createQuery("update AwardScheme a set a.price =:val  where a.awardName = :name");
        Query query2 = openSession().createQuery("update AwardScheme a set a.credits =:cre  where a.awardName = :name");
        query.setParameter("desc", desc);
        query1.setParameter("val", val);
        query.setParameter("name", aname);
        query1.setParameter("name", aname);
        query2.setParameter("name", aname);
        query2.setParameter("cre", credits);
        int result = query.executeUpdate();
        int res = query1.executeUpdate();
        res = query1.executeUpdate();

    }

    public List<User> getManagersList() {
        Query query = openSession().createQuery("from User u where u.emp_role = :var order by id ");
        query.setParameter("var", "MNGR");
        List<User> mngrlist = new ArrayList<User>();
        mngrlist = query.list();
        return mngrlist;
    }

    public List<Integer> getMngrById(int eid) {
        Query query = openSession().createQuery("select e.mid from EmployeeManager e where e.eid = :var");
        query.setParameter("var", eid);
        List<Integer> listm = new ArrayList<Integer>();
        listm = query.list();
        if (listm.size() > 0) {
            return listm;
        } else {
            return null;
        }
    }

    public List<User> getBuhList() {
        Query query = openSession().createQuery("from User u where u.emp_role = :var");
        query.setParameter("var", "BUH");
        List<User> buhlist = new ArrayList<User>();
        buhlist = query.list();
        return buhlist;
    }

    public List<User> getAllEmps() {
        Query query = openSession().createQuery("from User u where u.emp_role = :var");
        query.setParameter("var", "EMP");
        List<User> emplist = new ArrayList<User>();
        emplist = query.list();
        return emplist;

    }

    public User getBuhByMngr(int mid) {
        Query query = openSession().createQuery("from User u where u.id = some(select m.buhid from Manager m where m.mid = :var )");
        query.setParameter("var", mid);
        List<User> ulist = new ArrayList<User>();
        ulist = query.list();
        if (ulist.size() > 0) {
            return ulist.get(0);
        } else {
            return null;
        }
    }

    public void promoteToMngr(int eid) {
        Query query = openSession().createQuery("update EmpRole e set e.roleid = 3 where e.eid = :var");
        query.setParameter("var", eid);
        int res1 = query.executeUpdate();
        Query query1 = openSession().createQuery("update User e set e.emp_role='MNGR' where e.id = :var");
        query1.setParameter("var", eid);
        res1 = query1.executeUpdate();
        Query query2 = openSession().createQuery("delete from EmployeeManager e where e.eid=:var");
        query2.setParameter("var", eid);
        res1 = query2.executeUpdate();

    }

    public int getBuhById(int eid) {
        Query query = openSession().createQuery("select m.buhid from Manager m where m.mid = :var");
        query.setParameter("var", eid);
        List<Integer> list = new ArrayList<Integer>();
        list = query.list();
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return 0;
        }
    }

    public List<Integer> getEmpByMid(int eid) {
        List<Integer> emplist = new ArrayList<Integer>();
        Query query = openSession().createQuery("select em.eid from EmployeeManager em where em.mid = :var");
        query.setParameter("var", eid);
        emplist = query.list();
        if (emplist.size() > 0) {
            return emplist;
        } else {
            return null;
        }
    }

    public void promoteToBuh(int eid) {
        Query query = openSession().createQuery("update EmpRole e set e.roleid = 2 where e.eid = :var");
        query.setParameter("var", eid);
        int res1 = query.executeUpdate();
        BUH b = new BUH();
        b.setBuhid(eid);
        openSession().save(b);
        Query query1 = openSession().createQuery("update User e set e.emp_role='BUH' where e.id = :var");
        query1.setParameter("var", eid);
        res1 = query1.executeUpdate();
        Query query2 = openSession().createQuery("delete from EmployeeManager e where e.mid=:var or e.eid= :var");
        query2.setParameter("var", eid);
        res1 = query2.executeUpdate();

        Manager mng = new Manager();
        mng.setBuhid(11111);
        mng.setMid(eid);
        openSession().save(mng);

    }
}
