/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.service;

import com.sprsec.model.Approval;
import com.sprsec.model.Nomination;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface ApprovalService {

    public void addNomination(int nid, int buhid);

    public List<Nomination> getApprovalList(int eid);

    public List<Nomination> getAllApprovednominations(int eid);

    public long getApprovalCountByAwardScheme(Integer eid, String aname);

    public long getApprovalCountByDojandAwardScheme(String doj, String aname);

    public void setStatus(int parseInt);

    public List<Approval> recentAwards();

   
}
