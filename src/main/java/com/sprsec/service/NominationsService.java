/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.service;

import com.sprsec.model.Nomination;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface NominationsService {

    public List<Nomination> getNominations(int buhid);

    public void addNomination(Integer mid, Integer eid, String awardName);

    public List<Nomination> getNominationByMid(int mid);

    public void setStatusByNid(Integer nid);
    
    public long getNominationCountByAwardScheme(Integer eid, String aname);
    
    public long getNominationCountByDojandAwardScheme(String doj,String aname);

    public void addNominatedManager(Integer buhid, Integer mid, String awardScheme);

    public Nomination getNomination(Integer nid);
}
