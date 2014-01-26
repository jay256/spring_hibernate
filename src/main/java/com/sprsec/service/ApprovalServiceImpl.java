/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.service;

import com.sprsec.dao.ApprovalDAO;
import com.sprsec.model.Approval;
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
public class ApprovalServiceImpl implements ApprovalService {

    @Autowired
    private ApprovalDAO approvalDAO;

    public void addNomination(int nid, int buhid) {
        approvalDAO.addApproval(nid, buhid);
    }

    public List<Nomination> getApprovalList(int eid) {
        return approvalDAO.getListApproval(eid);
    }

    public List<Nomination> getAllApprovednominations(int eid) {
        return approvalDAO.getAllApprovedNominations(eid);
    }

    public long getApprovalCountByAwardScheme(Integer eid, String aname) {
        return approvalDAO.getApprovalCountByAwardScheme(eid, aname);
    }

    public long getApprovalCountByDojandAwardScheme(String doj, String aname) {
        return approvalDAO.getApprovalCountByDojandAwardScheme(doj, aname);
    }

    public void setStatus(int parseInt) {
        approvalDAO.setStatus(parseInt);
    }

    public List<Approval> recentAwards() {
        return approvalDAO.recentAwards();
    }

 
}
