/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.service;

import com.sprsec.model.AwardScheme;
import com.sprsec.model.User;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface AdminService {

    public List<AwardScheme> getAllSchemes();

    public String addNewEmp(String name, String dob, String doj, BigInteger phonenum, String role);

    public List<User> getManagersList();

    public List<User> getBuhList();

    public List<User> getAllEmps();

    public User getBuhByMngr(Integer id);

    public int addNewScheme(String aname, String desc, int parseInt, int parseInt0);

    public void deleteScheme(String aname);

    public void updateScheme(String aname, String desc, int parseInt, int parseInt0);

    public List<Integer> getMngrById(int eid);

    public void promoteToMngr(int eid);

    public void promoteToBuh(int eid);

    public int getBuhById(int eid);

    public List<Integer> getEmpByMid(int eid);
}
