/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.dao;

import com.sprsec.model.Approval;
import com.sprsec.model.Nomination;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class ApprovalDAOImpl implements ApprovalDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    public void addApproval(int nid, int buhid) {
        Approval a = new Approval();
        a.setNid(nid);
        a.setBuhid(buhid);
        a.setTime(ApprovalDAOImpl.getCurrentTimeStamp());
        getCurrentSession().save(a);
    }

    public List<Nomination> getListApproval(int eid) {
        List<Nomination> approveList = new ArrayList<Nomination>();
        Query query = getCurrentSession().createQuery("from Nomination n where n.eid = :eid and n.nid = some (select a.nid from Approval a where a.status = 0)");
        query.setParameter("eid", eid);
        approveList = query.list();
        if (approveList.size() > 0) {
            return approveList;
        } else {
            return new ArrayList<Nomination>();
        }
    }

    public List<Nomination> getAllApprovedNominations(int eid) {
        List<Nomination> allNominations = new ArrayList<Nomination>();
        Query query = getCurrentSession().createQuery("from Nomination n where n.eid=:eid and n.status=1");
        query.setParameter("eid", eid);
        allNominations = query.list();
        if (allNominations.size() > 0) {
            return allNominations;
        } else {
            return new ArrayList<Nomination>();
        }
    }

    public long getApprovalCountByAwardScheme(Integer eid, String aname) {
        Query query = getCurrentSession().createQuery("select count(*) from Approval a where a.nid = some (select n.nid from Nomination n where n.eid = :eid and n.aname = :aname))");
        query.setParameter("aname", aname);
        query.setParameter("eid", eid);
        return (Long) query.list().get(0);
    }

    public long getApprovalCountByDojandAwardScheme(String doj, String aname) {
        Query query = getCurrentSession().createQuery("select count(*) from Approval a where a.time>:doj and a.nid = some(select n.nid from Nomination n where n.aname=:aname))");
        query.setParameter("doj", doj);
        query.setParameter("aname", aname);
        return (Long) query.list().get(0);
    }

    public void setStatus(int parseInt) {
        Query query = getCurrentSession().createQuery("update Approval a set a.status=1 where a.nid=:nid");
        query.setParameter("nid", parseInt);
        int executeUpdate = query.executeUpdate();
    }

    public List<Approval> recentAwards() {
        List<Approval> recentawrds = new ArrayList<Approval>();
        Query query = getCurrentSession().createQuery("from Approval a order by a.time DESC");
        query.setMaxResults(5);
        recentawrds = query.list();
        if (recentawrds.size() > 0) {
            return recentawrds;
        } else {
            return new ArrayList<Approval>();
        }
    }
}
