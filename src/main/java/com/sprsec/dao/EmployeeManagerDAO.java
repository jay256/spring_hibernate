/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.dao;

import com.sprsec.model.User;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface EmployeeManagerDAO {
    public List<User> getEmployee(int mid);
}
