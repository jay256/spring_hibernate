/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.service;

import com.sprsec.dao.EmployeeManagerDAO;
import com.sprsec.model.User;
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
public class EmployeeManagerServiceImpl implements EmployeeManagerService {

    @Autowired
    private EmployeeManagerDAO emp_mngrDAO;

    public List<User> getEmployee(int mid) {
        return emp_mngrDAO.getEmployee(mid);
    }
}
