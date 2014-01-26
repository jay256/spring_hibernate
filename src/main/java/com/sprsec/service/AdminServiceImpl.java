/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.service;

import com.sprsec.dao.AdminDAO;
import com.sprsec.model.AwardScheme;
import com.sprsec.model.User;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SaiPramila
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    public String addNewEmp(String name, String dob, String doj, BigInteger phonenum, String role) {
        return adminDAO.addNewEmp(name, dob, doj, phonenum, role);
    }

    public List<AwardScheme> getAllSchemes() {
        return adminDAO.getAllSchemes();
    }

    public int addNewScheme(String aname, String desc, int val, int credits) {
        return adminDAO.addNewScheme(aname, desc, val, credits);
    }

    public void deleteScheme(String aname) {
        adminDAO.deleteScheme(aname);
    }

    public void updateScheme(String aname, String desc, int val, int credits) {
        adminDAO.updateScheme(aname, desc, val, credits);
    }

    public List<User> getManagersList() {
        return adminDAO.getManagersList();
    }

    public List<User> getBuhList() {
        return adminDAO.getBuhList();
    }

    public List<User> getAllEmps() {
        return adminDAO.getAllEmps();
    }

    public User getBuhByMngr(Integer mid) {
        return adminDAO.getBuhByMngr(mid);
    }

    public List<Integer> getMngrById(int eid) {
        return adminDAO.getMngrById(eid);
    }

    public void promoteToMngr(int eid) {
        adminDAO.promoteToMngr(eid);
    }

    public void promoteToBuh(int eid) {
        adminDAO.promoteToBuh(eid);
    }

    public int getBuhById(int eid) {
        return adminDAO.getBuhById(eid);
    }

    public List<Integer> getEmpByMid(int eid) {
        return adminDAO.getEmpByMid(eid);
    }
}
