/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprsec.service;

import com.sprsec.dao.BuhDAO;
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
public class BuhServiceImpl implements BuhService{
    
    @Autowired
    private BuhDAO buhDAO;
    
    public List<User> getManagers(int buhid){
        return buhDAO.getManagers(buhid);
    }
}
