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
public class NominationsDAOImpl implements NominationsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    public List<Nomination> getNominations(int id) {
        List<Nomination> nominationsList = new ArrayList<Nomination>();
        Query query = openSession().createQuery("from Nomination n where n.mid = some (select m.mid from Manager m where m.buhid = :temp)order by n.eid asc ");
        query.setParameter("temp", id);                                                                              //order by n.aname asc                                
        nominationsList = query.list();
        if (nominationsList.size() > 0) {
            return nominationsList;
        } else {
            return new ArrayList<Nomination>();
        }
    }

    public void addNomination(Integer mid, Integer eid, String awardName) {
        Nomination n = new Nomination();
        n.setAname(awardName);
        n.setMid(mid);
        n.setEid(eid);
        n.setTime(NominationsDAOImpl.getCurrentTimeStamp());
        openSession().save(n);
    }

    public List<Nomination> getNominationByMid(int mid) {
        List<Nomination> nominations = new ArrayList<Nomination>();
        Query query = openSession().createQuery("from Nomination n where n.mid = :mid and n.status=0");
        query.setParameter("mid", mid);
        nominations = query.list();
        if (nominations.size() > 0) {
            return nominations;
        } else {
            return new ArrayList<Nomination>();
        }
    }

    public void setStatusByNid(Integer nid) {
        Query query = openSession().createQuery("update Nomination n set n.status=1 where n.nid=:nid");
        query.setParameter("nid", nid);
        int executeUpdate = query.executeUpdate();
    }

    public long getNominationCountByAwardScheme(Integer eid, String aname) {
        Query query = openSession().createQuery("select count(*) from Nomination n where n.aname = :aname and n.eid = :eid");
        query.setParameter("aname", aname);
        query.setParameter("eid", eid);
        return (Long) query.list().get(0);
    }

    public long getNominationCountByDojandAwardScheme(String doj, String aname) {
        Query query = openSession().createQuery("select count(*) from Nomination n where n.time > :doj and n.nid = some (select n1.nid from Nomination n1 where n1.aname = :aname)");
        query.setParameter("aname", aname);
        query.setParameter("doj", doj);
        return (Long) query.list().get(0);
    }

    public void addNominatedManager(Integer buhid, Integer mid, String awardScheme) {
        Nomination n = new Nomination();
        n.setAname(awardScheme);
        n.setMid(buhid);
        n.setEid(mid);
        n.setStatus(1);
        n.setTime(NominationsDAOImpl.getCurrentTimeStamp());
        openSession().save(n);
        Approval a = new Approval();
        int nid = n.getNid();
        a.setBuhid(buhid);
        a.setNid(nid);
        a.setTime(NominationsDAOImpl.getCurrentTimeStamp());
        openSession().save(a);
    }

    public Nomination getNomination(int nid) {
        Query query = openSession().createQuery("from Nomination n where n.nid = :id");
        query.setParameter("id", nid);
        List<Nomination> nomin = new ArrayList<Nomination>();
        nomin = query.list();
        return nomin.get(0);
    }
}
