/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.service;

import com.sprsec.model.User;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface BuhService {
    public List<User> getManagers(int buhid);
}
