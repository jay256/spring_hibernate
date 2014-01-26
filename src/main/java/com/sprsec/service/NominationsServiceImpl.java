/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.service;

import com.sprsec.dao.NominationsDAO;
import com.sprsec.model.Nomination;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Service
@Transactional
public class NominationsServiceImpl implements NominationsService {

    @Autowired
    private NominationsDAO nominationsDAO;

    public List<Nomination> getNominations(int buhid) {
        return nominationsDAO.getNominations(buhid);
    }

    public void addNomination(Integer mid, Integer eid, String awardName) {
        nominationsDAO.addNomination(mid, eid, awardName);
    }
    
    public List<Nomination> getNominationByMid(int mid){
        return nominationsDAO.getNominationByMid(mid);
    }

    public void setStatusByNid(Integer nid) {
        nominationsDAO.setStatusByNid(nid);    
    }

    public long getNominationCountByAwardScheme(Integer eid, String aname) {
        return nominationsDAO.getNominationCountByAwardScheme(eid, aname);
    }

    public long getNominationCountByDojandAwardScheme(String doj,String aname) {
        return nominationsDAO.getNominationCountByDojandAwardScheme(doj, aname);
    }

    public void addNominatedManager(Integer buhid, Integer mid, String awardScheme) {
        nominationsDAO.addNominatedManager(buhid,mid,awardScheme);
    }

    public Nomination getNomination(Integer nid) {
        return nominationsDAO.getNomination(nid);
    }
}
